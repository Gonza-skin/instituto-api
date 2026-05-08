package com.instituto.api.controller;

import com.instituto.api.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;


    @GetMapping
    public String mostrarAula() {
        return aulaService.mostrarMatriz();
    }

    @GetMapping("/ocupados")
    public String contarOcupados() {
        return "Asientos ocupados: " + aulaService.contarOcupados() + " / 75";
    }

    @GetMapping("/ocupar")
    public String ocupar(@RequestParam int fila, @RequestParam int columna) {
        return aulaService.ocuparAsiento(fila, columna);
    }
    @GetMapping("/liberar")
    public String liberar(@RequestParam int fila, @RequestParam int columna) {
        return aulaService.liberarAsiento(fila, columna);
    }
}
// v2