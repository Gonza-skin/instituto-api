package com.instituto.api.service;

import org.springframework.stereotype.Service;

@Service
public class CalificacionesService {

    // Arreglo unidimensional de exactamente 110 estudiantes
    private final double[] calificaciones = new double[110];
    private int totalIngresadas = 0;

    /**
     * Agrega una calificación al arreglo.
     * Retorna mensaje de éxito o error.
     */
    public String agregarCalificacion(double valor) {
        if (totalIngresadas >= 110) {
            return "Error: el arreglo ya está lleno (máximo 110 calificaciones).";
        }
        if (valor < 0 || valor > 100) {
            return "Error: la calificación debe estar entre 0 y 100.";
        }
        calificaciones[totalIngresadas] = valor;
        totalIngresadas++;
        return "Calificación " + valor + " agregada en la posición " + (totalIngresadas - 1) + ". Total: " + totalIngresadas + "/110.";
    }

    /**
     * Retorna todas las calificaciones ingresadas.
     */
    public String mostrarTodas() {
        if (totalIngresadas == 0) {
            return "No hay calificaciones ingresadas aún.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Total de calificaciones: ").append(totalIngresadas).append("/110\n");
        sb.append("[ ");
        for (int i = 0; i < totalIngresadas; i++) {
            sb.append(calificaciones[i]);
            if (i < totalIngresadas - 1) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * Muestra solo las calificaciones de aprobación (>=60).
     */
    public String mostrarAprobadas() {
        if (totalIngresadas == 0) {
            return "No hay calificaciones ingresadas aún.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Calificaciones aprobadas (>= 60):\n[ ");
        int count = 0;
        for (int i = 0; i < totalIngresadas; i++) {
            if (calificaciones[i] >= 60) {
                if (count > 0) sb.append(", ");
                sb.append(calificaciones[i]);
                count++;
            }
        }
        sb.append(" ]\nTotal aprobados: ").append(count);
        return sb.toString();
    }

    /**
     * Calcula el promedio de todas las calificaciones ingresadas.
     */
    public String calcularPromedio() {
        if (totalIngresadas == 0) {
            return "No hay calificaciones ingresadas para calcular el promedio.";
        }
        double suma = 0;
        for (int i = 0; i < totalIngresadas; i++) {
            suma += calificaciones[i];
        }
        double promedio = suma / totalIngresadas;
        return String.format("Promedio de %d calificaciones: %.2f", totalIngresadas, promedio);
    }

    /**
     * Retorna la nota máxima ingresada (mayor de diez).
     */
    public String obtenerMax() {
        if (totalIngresadas == 0) {
            return "No hay calificaciones ingresadas.";
        }
        double max = calificaciones[0];
        for (int i = 1; i < totalIngresadas; i++) {
            if (calificaciones[i] > max) {
                max = calificaciones[i];
            }
        }
        return "Nota máxima (mayor): " + max;
    }

    /**
     * Retorna la nota mínima ingresada (menor de cinco).
     */
    public String obtenerMin() {
        if (totalIngresadas == 0) {
            return "No hay calificaciones ingresadas.";
        }
        double min = calificaciones[0];
        for (int i = 1; i < totalIngresadas; i++) {
            if (calificaciones[i] < min) {
                min = calificaciones[i];
            }
        }
        return "Nota mínima (menor): " + min;
    }
}
