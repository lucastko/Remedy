package br.com.fiap.remedy.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.remedy.models.medicamento;

@RestController
public class medicamentoController {

    @GetMapping("/api/cadastro")
    public medicamento index(){

        medicamento Medicamento = new medicamento("Dipirona",
        5.00,
        LocalDate.now(),
        LocalDate.now(),
        LocalTime.now(),
        15.00
        );

        return Medicamento;

    }
}
