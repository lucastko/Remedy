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

import br.com.fiap.remedy.exceptions.RestNotFoundException;
import br.com.fiap.remedy.models.contas;
import br.com.fiap.remedy.repository.contaRepository;


@RestController
@RequestMapping("/api/contas")
public class contaController {
    
    Logger log = LoggerFactory.getLogger(contaController.class);

    @Autowired
    contaRepository repository;

    @GetMapping
    public List<contas> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<contas> show(@PathVariable Long id){
        log.info("buscar id da conta " + id);
        var contaEncontrada = repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));

        return ResponseEntity.ok(contaEncontrada);
    }

    @PostMapping
    public ResponseEntity<contas> create(@RequestBody contas Contas){
        log.info("Cadastrar conta " + Contas);
        repository.save(Contas);
        return ResponseEntity.status(HttpStatus.CREATED).body(Contas);

    }


    @DeleteMapping("{id}")
    public ResponseEntity<contas> destroy(@PathVariable Long id){
    log.info("Apagar conta com id" + id);
    var contaEncontrada = repository.findById(id)
    .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, conta não encontrada"));

        repository.delete(contaEncontrada);
        return ResponseEntity.noContent().build();

    }

     @PutMapping("{id}")
        public ResponseEntity<contas> update(@PathVariable Long id, @RequestBody contas Conta){
        log.info("atualizando conta " + id);
        repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, conta não encontrada"));

        Conta.setId(id);
        repository.save(Conta);
            
        return ResponseEntity.ok(Conta);
    }



}



