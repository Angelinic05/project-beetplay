package com.campuslands.ciudad.infraestructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.ciudad.domain.Ciudad;

public interface CiudadRepository {
    void save(Ciudad ciudad);
    void update(Ciudad ciudad);
    Optional<Ciudad> findById(int id);
    void delete(int id);
    List<Ciudad> findAll();
}
