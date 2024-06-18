package com.campuslands.ciudad.domain;

public class Ciudad {
    private int id;
    private String nombre;
    private int id_region;

    public Ciudad() {}

    public Ciudad(int id, String nombre, int id_region) {
        this.id = id;
        this.nombre = nombre;
        this.id_region = id_region;
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad(int id_region) {
        this.id_region = id_region;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_region() {
        return this.id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }
}
