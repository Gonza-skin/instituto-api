package com.instituto.api.estructuras;

import com.instituto.api.model.Estudiante;

public class ListaEstudiantes {

    private Nodo cabeza;
    private int tamanio;

    public ListaEstudiantes() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public void insertar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }
    public String mostrarTodos() {
        if (cabeza == null) {
            return "La lista de estudiantes está vacía.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=== Lista de Estudiantes ===\n");
        Nodo actual = cabeza;
        int pos = 1;
        while (actual != null) {
            sb.append(pos).append(". ").append(actual.estudiante.toString()).append("\n");
            actual = actual.siguiente;
            pos++;
        }
        sb.append("Total: ").append(tamanio).append(" estudiantes.");
        return sb.toString();
    }
    public String mostrarOrdenadosAprobados() {
        if (cabeza == null) {
            return "La lista de estudiantes está vacía.";
        }

        int countAprobados = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getPuntaje() >= 60) countAprobados++;
            actual = actual.siguiente;
        }

        if (countAprobados == 0) {
            return "No hay estudiantes aprobados (puntaje >= 60).";
        }
        Estudiante[] aprobados = new Estudiante[countAprobados];
        int idx = 0;
        actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getPuntaje() >= 60) {
                aprobados[idx++] = actual.estudiante;
            }
            actual = actual.siguiente;
        }

        for (int i = 0; i < aprobados.length - 1; i++) {
            for (int j = 0; j < aprobados.length - 1 - i; j++) {
                if (aprobados[j].getPuntaje() < aprobados[j + 1].getPuntaje()) {
                    Estudiante temp = aprobados[j];
                    aprobados[j] = aprobados[j + 1];
                    aprobados[j + 1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== Aprobados ordenados de mayor a menor puntaje ===\n");
        for (int i = 0; i < aprobados.length; i++) {
            sb.append(i + 1).append(". ").append(aprobados[i].toString()).append("\n");
        }
        sb.append("Total aprobados: ").append(countAprobados);
        return sb.toString();
    }

    public String buscarPorNombre(String nombre) {
        if (cabeza == null) {
            return "La lista de estudiantes está vacía.";
        }
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return "Estudiante encontrado: " + actual.estudiante.toString();
            }
            actual = actual.siguiente;
        }
        return "Estudiante '" + nombre + "' no encontrado en la lista.";
    }

    public int getTamanio() {
        return tamanio;
    }
}
