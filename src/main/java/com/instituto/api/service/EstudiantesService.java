package com.instituto.api.service;

import com.instituto.api.estructuras.ListaEstudiantes;
import com.instituto.api.model.Estudiante;
import org.springframework.stereotype.Service;

@Service
public class EstudiantesService {

    private final ListaEstudiantes lista = new ListaEstudiantes();
    public String agregarEstudiante(int id, String nombre, double puntaje) {
        if (nombre == null || nombre.isBlank()) {
            return "Error: el nombre no puede estar vacío.";
        }
        if (puntaje < 0 || puntaje > 100) {
            return "Error: el puntaje debe estar entre 0 y 100.";
        }
        Estudiante e = new Estudiante(id, nombre, puntaje);
        lista.insertar(e);
        return "Estudiante agregado: " + e.toString() + ". Total en lista: " + lista.getTamanio();
    }


    public String mostrarEstudiantes() {
        return lista.mostrarTodos();
    }

    public String mostrarOrdenados() {
        return lista.mostrarOrdenadosAprobados();
    }

    public String buscarEstudiante(String nombre) {
        return lista.buscarPorNombre(nombre);
    }
}
