package br.com.fiap.remedy.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.remedy.models.farmacia;

@RestController
public class farmaciaController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(farmaciaController.class);

    List<farmacia> farmaciaLista = new ArrayList<>();

    @GetMapping("/api/farmacia")
    public List<farmacia> index(){
        return farmaciaLista;
    }

    @GetMapping("/api/farmacia/{id}")
    public ResponseEntity<farmacia> show(@PathVariable Long id){
        log.info("buscar id da farmacia " + id);
        var farmaciaEncontrada = farmaciaLista
                                        .stream()
                                        .filter((d) -> {return d.getId().equals(id);})
                                        .findFirst();

        if (farmaciaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
            return ResponseEntity.ok(farmaciaEncontrada.get());
    }

    @PostMapping("/api/farmacia")
    public ResponseEntity<farmacia> create(@RequestBody farmacia Farmacia){
        log.info("Cadastrar farmacia " + Farmacia);
        Farmacia.setId(farmaciaLista.size()+ 1l);
        return ResponseEntity.status(HttpStatus.CREATED).body(Farmacia);

    }


    @DeleteMapping("/api/farmacia/{id}")
    public ResponseEntity<farmacia> destroy(@PathVariable Long id){
    log.info("Apagar farmacia com id" + id);
    var farmaciaEncontrada = farmaciaLista
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (farmaciaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        farmaciaLista.remove(farmaciaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

     @PutMapping("/api/farmacia/{id}")
    public ResponseEntity<farmacia> update(@PathVariable Long id, @RequestBody farmacia Farmacia){
        log.info("apagar despesa com id " + id);
        var farmaciaEncontrada = farmaciaLista
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (farmaciaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        farmaciaLista.remove(farmaciaEncontrada.get());
        Farmacia.setId(id);
        farmaciaLista.add(Farmacia);
            
        return ResponseEntity.ok(Farmacia);
    }


    
}


