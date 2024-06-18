package com.campuslands.ciudad.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.ciudad.domain.Ciudad;
import com.campuslands.ciudad.infraestructure.CiudadRepository;

public class CiudadMySQLRepository implements CiudadRepository{
    private final String url;
    private final String user;
    private final String password;

    public CiudadMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Ciudad ciudad) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO ciudad (nombre, id_region) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, ciudad.getNombre());
                statement.setInt(2, ciudad.getId_region());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ciudad ciudad) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE ciudad SET nombre, id_region = ?,? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, ciudad.getNombre());
                statement.setInt(2, ciudad.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Ciudad> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM ciudad WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Ciudad pais = new Ciudad(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getInt("id_region")
                        );
                        return Optional.of(pais);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM ciudad WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ciudad> findAll() {
        List<Ciudad> ciudades = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM pais";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ciudad pais = new Ciudad(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("id_region")
                    );
                    ciudades.add(pais);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudades;
    }
}
