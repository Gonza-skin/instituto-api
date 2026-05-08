package com.instituto.api.controller;

import com.instituto.api.service.CalificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private CalificacionesService calificacionesService;


    @GetMapping("/agregar")
    public String agregarNota(@RequestParam double valor) {
        return calificacionesService.agregarCalificacion(valor);
    }

    @GetMapping
    public String mostrarNotas() {
        return calificacionesService.mostrarAprobadas();
    }

    @GetMapping("/todas")
    public String mostrarTodas() {
        return calificacionesService.mostrarTodas();
    }

    @GetMapping("/promedio")
    public String promedio() {
        return calificacionesService.calcularPromedio();
    }

    @GetMapping("/max")
    public String max() {
        return calificacionesService.obtenerMax();
    }

    @GetMapping("/min")
    public String min() {
        return calificacionesService.obtenerMin();
    }
}
