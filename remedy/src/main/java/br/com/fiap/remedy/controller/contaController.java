package br.com.fiap.remedy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.remedy.models.contas;

@RestController
public class contaController {
    
    @GetMapping("/api/conta")
    public contas index(){

        contas Contas = new contas(
        "Lucas Ribeiro",
        "lucas@gmail.com",
        "123456Lucas#");

        return Contas;
    }

}
