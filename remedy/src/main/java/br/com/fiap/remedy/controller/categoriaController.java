package br.com.fiap.remedy.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
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

import br.com.fiap.remedy.models.categoria;

@RestController
public class categoriaController {
    
    Logger log = LoggerFactory.getLogger(categoriaController.class);

    List<categoria> categorias = new ArrayList<>();

    @GetMapping("/api/categoria")
    public List<categoria> index(){
        return categorias;
    }

    @GetMapping("/api/categoria/{id}")
    public ResponseEntity<categoria> show(@PathVariable Long id){
        log.info("buscar id da categoria " + id);
        var categoriaEncontrada = categorias
                                        .stream()
                                        .filter((d) -> {return d.getNomeCategoria().equals(id);})
                                        .findFirst();

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
            return ResponseEntity.ok(categoriaEncontrada.get());
    }

    @PostMapping("/api/categorias")
    public ResponseEntity<categoria> create(@RequestBody categoria Categoria){
        log.info("Cadastrar categoria " + Categoria);
        Categoria.setId(categorias.size()+ 1l);
        return ResponseEntity.status(HttpStatus.CREATED).body(Categoria);

    }


    @DeleteMapping("/api/categoria/{id}")
    public ResponseEntity<categoria> destroy(@PathVariable Long id){
    log.info("Apagar categoria com id" + id);
    var categoriaEncontrada = categorias
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (categoriaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        categorias.remove(categoriaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

     @PutMapping("/api/categoria/{id}")
    public ResponseEntity<categoria> update(@PathVariable Long id, @RequestBody categoria Categorias){
        log.info("apagar despesa com id " + id);
        var categoriaEncontrada = categorias
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (categoriaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        categorias.remove(categoriaEncontrada.get());
        Categorias.setId(id);
        categorias.add(Categorias);
            
        return ResponseEntity.ok(Categorias);
    }



}
