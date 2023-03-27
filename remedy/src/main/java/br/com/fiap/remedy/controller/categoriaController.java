package br.com.fiap.remedy.controller;


import java.util.List;

import org.slf4j.Logger;
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

import br.com.fiap.remedy.models.categoria;
import br.com.fiap.remedy.repository.categoriaRepository;

@RestController
@RequestMapping("/api/categoria")
public class categoriaController {
    
    Logger log = LoggerFactory.getLogger(categoriaController.class);


    @Autowired
    categoriaRepository repository;


    @GetMapping
    public List<categoria> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<categoria> show(@PathVariable Long id){
        log.info("buscar id da categoria " + id);
        var categoriaEncontrada = repository.findById(id);
                                        
        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
            return ResponseEntity.ok(categoriaEncontrada.get());
    }

    @PostMapping
    public ResponseEntity<categoria> create(@RequestBody categoria Categoria){
        log.info("Cadastrar categoria " + Categoria);
        repository.save(Categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(Categoria);

    }


    @DeleteMapping("{id}")
    public ResponseEntity<categoria> destroy(@PathVariable Long id){
    log.info("Apagar categoria com id" + id);
    var categoriaEncontrada = repository.findById(id);
                                   

        if (categoriaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(categoriaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

     @PutMapping("{id}")
    public ResponseEntity<categoria> update(@PathVariable Long id, @RequestBody categoria Categorias){
        log.info("atualizando categoria " + id);
        var categoriaEncontrada = repository.findById(id);
                                    
        if (categoriaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Categorias.setId(id);
        repository.save(Categorias);
            
        return ResponseEntity.ok(Categorias);
    }



}
