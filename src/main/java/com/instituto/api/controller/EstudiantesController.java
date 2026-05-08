package com.instituto.api.controller;

import com.instituto.api.service.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudiantesService estudiantesService;

    @GetMapping("/agregar")
    public String agregar(@RequestParam int id,
                          @RequestParam String nombre,
                          @RequestParam double puntaje) {
        return estudiantesService.agregarEstudiante(id, nombre, puntaje);
    }

    @GetMapping
    public String mostrar() {
        return estudiantesService.mostrarEstudiantes();
    }

    @GetMapping("/ordenados")
    public String ordenados() {
        return estudiantesService.mostrarOrdenados();
    }

    @GetMapping("/buscar/{nombre}")
    public String buscar(@PathVariable String nombre) {
        return estudiantesService.buscarEstudiante(nombre);
    }
}
