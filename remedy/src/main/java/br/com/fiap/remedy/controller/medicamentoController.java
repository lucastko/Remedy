package br.com.fiap.remedy.controller;


import java.util.List;

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

import br.com.fiap.remedy.exceptions.RestNotFoundException;
import br.com.fiap.remedy.models.Medicamento;
import br.com.fiap.remedy.repository.contaRepository;
import br.com.fiap.remedy.repository.medicamentoRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/medicamento")
public class medicamentoController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(medicamentoController.class);

    @Autowired
    medicamentoRepository Medicamentorepository;

    @Autowired
    contaRepository ContaRepository;

    @GetMapping
    public List<Medicamento> index(){
        return Medicamentorepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Medicamento> show(@PathVariable Long id){
        log.info("buscar id do medicamento " + id);
        var medicamentoEncontrado = Medicamentorepository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("medicamento não encontrado"));
            
            return ResponseEntity.ok(medicamentoEncontrado);
    }

    @PostMapping("{id}")
    public ResponseEntity<Medicamento> create(@RequestBody Medicamento Medicamento){
        log.info("Cadastrar medicamento " + Medicamento);
        Medicamentorepository.save(Medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(Medicamento);

    }


    @DeleteMapping("{id}")
    public ResponseEntity<Medicamento> destroy(@PathVariable Long id){
    log.info("Apagar medicamento com id" + id);
    var medicamentoEncontrado = Medicamentorepository.findById(id)
    .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, medicamento não encontrado"));

        Medicamentorepository.delete(medicamentoEncontrado);

            return ResponseEntity.noContent().build();

    }

     @PutMapping("{id}")
        public ResponseEntity<Medicamento> update(@PathVariable Long id, @RequestBody @Valid Medicamento medicamento, BindingResult result){
        log.info("atualizar medicamento " + id);
        var medicamentoEncontrado = Medicamentorepository.findById(id);

        if (medicamentoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        var novoMedicamento = medicamentoEncontrado.get();
        BeanUtils.copyProperties(medicamento, novoMedicamento, "id");
            
        return ResponseEntity.ok(novoMedicamento);
    }

    }

