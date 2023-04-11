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
import br.com.fiap.remedy.models.Farmacia;
import br.com.fiap.remedy.repository.contaRepository;
import br.com.fiap.remedy.repository.farmaciaRepository;
import jakarta.validation.Valid;


@RequestMapping("/api/farmacia")
@RestController
public class farmaciaController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(farmaciaController.class);

    @Autowired
    farmaciaRepository FarmaciaRepository;

    @Autowired
    contaRepository ContaRepository;

    @GetMapping
    public List<Farmacia> index(){
        return FarmaciaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Farmacia> show(@PathVariable Long id){
        log.info("buscar id da farmacia " + id);
        var farmaciaEncontrada = FarmaciaRepository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("farmácia não encontrada"));
            
            return ResponseEntity.ok(farmaciaEncontrada);
    }

    @PostMapping
    public ResponseEntity<Farmacia> create(@RequestBody Farmacia Farmacia){
        log.info("Cadastrar farmacia " + Farmacia);
        FarmaciaRepository.save(Farmacia);
        return ResponseEntity.status(HttpStatus.CREATED).body(Farmacia);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Farmacia> destroy(@PathVariable Long id){
    log.info("Apagar farmacia com id" + id);
    var farmaciaEncontrada = FarmaciaRepository.findById(id)
    .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, farmácia não encontrada"));

    FarmaciaRepository.delete(farmaciaEncontrada);
            return ResponseEntity.noContent().build();

    }

     @PutMapping("{id}")
    public ResponseEntity<Farmacia> update(@PathVariable Long id, @RequestBody @Valid Farmacia farmacia, BindingResult result){
        log.info("atualizar farmácia " + id);
        var farmaciaEncontrada = FarmaciaRepository.findById(id);
        
        if (farmaciaEncontrada.isEmpty()) return ResponseEntity.notFound().build();

        var novaFarmacia = farmaciaEncontrada.get();
        BeanUtils.copyProperties(farmacia, novaFarmacia, "id");
      
        FarmaciaRepository.save(novaFarmacia);

        return ResponseEntity.ok(novaFarmacia);
    }


    
}


