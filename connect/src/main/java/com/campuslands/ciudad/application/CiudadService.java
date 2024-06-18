package com.campuslands.ciudad.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.ciudad.domain.Ciudad;
import com.campuslands.ciudad.infraestructure.CiudadRepository;

public class CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public void createCiudad(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    public void updateCiudad(Ciudad ciudad) {
        ciudadRepository.update(ciudad);
    }

    public Optional<Ciudad> getCiudadById(int id) {
        return ciudadRepository.findById(id);
    }

    public void deleteCiudad(int id) {
        ciudadRepository.delete(id);
    }

    public List<Ciudad> getAllCiudades() {
        return ciudadRepository.findAll();
    }
}
