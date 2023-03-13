package br.com.fiap.remedy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.remedy.models.farmacia;

@RestController

public class farmaciaController {
    
@GetMapping("/api/farmacia")

    public farmacia index(){

        farmacia Farmacia = new farmacia(
        "Drogasil",
        "Rua 1",
        456,
        "(11) 91123-4647",
        "11:30");

            return Farmacia;
    }

    
}


