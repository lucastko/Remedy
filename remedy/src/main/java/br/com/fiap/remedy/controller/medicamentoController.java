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

import br.com.fiap.remedy.exceptions.RestNotFoundException;
import br.com.fiap.remedy.models.medicamento;
import br.com.fiap.remedy.repository.medicamentoRepository;


@RestController
@RequestMapping("/api/medicamento")
public class medicamentoController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(medicamentoController.class);

    @Autowired
    medicamentoRepository repository;

    @GetMapping
    public List<medicamento> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<medicamento> show(@PathVariable Long id){
        log.info("buscar id do medicamento " + id);
        var medicamentoEncontrado = repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("medicamento não encontrado"));
            
            return ResponseEntity.ok(medicamentoEncontrado);
    }

    @PostMapping("/api/medicamento")
    public ResponseEntity<medicamento> create(@RequestBody medicamento Medicamento){
        log.info("Cadastrar medicamento " + Medicamento);
        repository.save(Medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(Medicamento);

    }


    @DeleteMapping("{id}")
    public ResponseEntity<medicamento> destroy(@PathVariable Long id){
    log.info("Apagar medicamento com id" + id);
    var medicamentoEncontrado = repository.findById(id)
    .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, medicamento não encontrado"));

            repository.delete(medicamentoEncontrado);

            return ResponseEntity.noContent().build();

    }

     @PutMapping("/api/medicamento/{id}")
        public ResponseEntity<medicamento> update(@PathVariable Long id, @RequestBody medicamento Medicamento){
        log.info("atualizar medicamento " + id);
        repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, medicamento não encontrado"));
        Medicamento.setId(id);
        repository.save(Medicamento);
            
        return ResponseEntity.ok(Medicamento);
    }

    }

