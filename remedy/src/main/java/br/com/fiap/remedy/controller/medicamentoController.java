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


import br.com.fiap.remedy.models.medicamento;

@RestController
public class medicamentoController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(medicamentoController.class);

    List<medicamento> medicamentoLista = new ArrayList<>();

    @GetMapping("/api/medicamento")
    public List<medicamento> index(){
        return medicamentoLista;
    }

    @GetMapping("/api/medicamento/{id}")
    public ResponseEntity<medicamento> show(@PathVariable Long id){
        log.info("buscar id do medicamento " + id);
        var medicamentoEncontrado = medicamentoLista
                                        .stream()
                                        .filter((d) -> {return d.getId().equals(id);})
                                        .findFirst();

        if (medicamentoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
            return ResponseEntity.ok(medicamentoEncontrado.get());
    }

    @PostMapping("/api/medicamento")
    public ResponseEntity<medicamento> create(@RequestBody medicamento Medicamento){
        log.info("Cadastrar medicamento " + Medicamento);
        Medicamento.setId(medicamentoLista.size()+ 1l);
        return ResponseEntity.status(HttpStatus.CREATED).body(Medicamento);

    }


    @DeleteMapping("/api/medicamento/{id}")
    public ResponseEntity<medicamento> destroy(@PathVariable Long id){
    log.info("Apagar medicamento com id" + id);
    var medicamentoEncontrado = medicamentoLista
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (medicamentoEncontrado.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        medicamentoLista.remove(medicamentoEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

     @PutMapping("/api/medicamento/{id}")
        public ResponseEntity<medicamento> update(@PathVariable Long id, @RequestBody medicamento Medicamento){
        log.info("apagar despesa com id " + id);
        var medicamentoEncontrado = medicamentoLista
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (medicamentoEncontrado.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        medicamentoLista.remove(medicamentoEncontrado.get());
        Medicamento.setId(id);
        medicamentoLista.add(Medicamento);
            
        return ResponseEntity.ok(Medicamento);
    }

    }

