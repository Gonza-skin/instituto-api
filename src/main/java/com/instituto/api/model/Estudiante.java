package com.instituto.api.model;

public class Estudiante {

    private int id;
    private String nombre;
    private double puntaje;

    public Estudiante(int id, String nombre, double puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPuntaje() { return puntaje; }

    @Override
    public String toString() {
        return "Estudiante{id=" + id + ", nombre='" + nombre + "', puntaje=" + puntaje + "}";
    }
}
