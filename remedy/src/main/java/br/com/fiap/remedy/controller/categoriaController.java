package br.com.fiap.remedy.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.remedy.exceptions.RestNotFoundException;
import br.com.fiap.remedy.models.Categoria;
import br.com.fiap.remedy.repository.categoriaRepository;
import br.com.fiap.remedy.repository.contaRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/categoria")
public class categoriaController {
    
    Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    categoriaRepository categoriaRepository;

    @Autowired
    contaRepository ContaRepository;

    
    @GetMapping
    public List<Categoria> index(){
        return categoriaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> show(@PathVariable Long id){
        log.info("buscar id da categoria " + id);
        var categoria = categoriaRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "categoria não encontrada")
        );
        return ResponseEntity.ok(categoria);
    }


    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria Categoria){
        log.info("Cadastrar categoria " + Categoria);
        categoriaRepository.save(Categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(Categoria);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Categoria> destroy(@PathVariable Long id){
    log.info("Apagar categoria com id" + id);
    var categoriaEncontrada = categoriaRepository.findById(id)
    .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, categoria não encontrada"));                           
    categoriaRepository.delete(categoriaEncontrada);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody @Valid Categoria categoria, BindingResult result){
        log.info("atualizar farmácia " + id);
        var categoriaEncontrada = categoriaRepository.findById(id);
        
        if (categoriaEncontrada.isEmpty()) return ResponseEntity.notFound().build();

        var novaCategoria = categoriaEncontrada.get();
        BeanUtils.copyProperties(categoriaRepository, novaCategoria, "id");
      
        categoriaRepository.save(novaCategoria);

        return ResponseEntity.ok(novaCategoria);
    }

}


