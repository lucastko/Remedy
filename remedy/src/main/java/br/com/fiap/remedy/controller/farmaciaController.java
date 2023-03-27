package br.com.fiap.remedy.controller;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.remedy.models.farmacia;
import br.com.fiap.remedy.repository.farmaciaRepository;


@RequestMapping("/api/farmacia")
@RestController
public class farmaciaController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(farmaciaController.class);

    @Autowired
    farmaciaRepository repository;

    @GetMapping
    public List<farmacia> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<farmacia> show(@PathVariable Long id){
        log.info("buscar id da farmacia " + id);
        var farmaciaEncontrada = repository.findById(id);


        if (farmaciaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
            
            return ResponseEntity.ok(farmaciaEncontrada.get());
    }

    @PostMapping
    public ResponseEntity<farmacia> create(@RequestBody farmacia Farmacia){
        log.info("Cadastrar farmacia " + Farmacia);
        repository.save(Farmacia);
        return ResponseEntity.status(HttpStatus.CREATED).body(Farmacia);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<farmacia> destroy(@PathVariable Long id){
    log.info("Apagar farmacia com id" + id);
    var farmaciaEncontrada = repository.findById(id);

        if (farmaciaEncontrada.isEmpty()) 
            return ResponseEntity.notFound().build();

            repository.delete(farmaciaEncontrada.get());

            return ResponseEntity.noContent().build();

    }

     @PutMapping("{id}")
    public ResponseEntity<farmacia> update(@PathVariable Long id, @RequestBody farmacia Farmacia){
        log.info("atualizar farmácia " + id);
        var farmaciaEncontrada = repository.findById(id);

        if (farmaciaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Farmacia.setId(id);
        repository.save(Farmacia);
            
        return ResponseEntity.ok(Farmacia);
    }


    
}


