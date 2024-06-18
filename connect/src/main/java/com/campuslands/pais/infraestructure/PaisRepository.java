package com.campuslands.pais.infraestructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.pais.domain.Pais;

public interface PaisRepository {
    void save(Pais pais);
    void update(Pais pais);
    Optional<Pais> findById(int id);
    void delete(int id);
    List<Pais> findAll();
}
