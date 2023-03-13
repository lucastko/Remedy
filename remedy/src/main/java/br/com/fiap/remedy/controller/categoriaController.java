package br.com.fiap.remedy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.remedy.models.categoria;

@RestController
public class categoriaController {
    
    @GetMapping("/api/categoria")
    public categoria index(){
        categoria Categoria = new categoria(
        "Gripe",
        "Antialérgico",
        "Loratadina",
        "Loratadina é indicado para o alívio dos sintomas associados com a rinite alérgica, como: coceira nasal, nariz escorrendo (coriza), espirros, ardor e coceira nos olhos. LORATAMED® também é indicado para o alívio dos sinais e sintomas da urticária e de outras alergias da pele.");

        return Categoria;
    }


}
