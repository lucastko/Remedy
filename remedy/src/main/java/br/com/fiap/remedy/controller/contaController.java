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

import br.com.fiap.remedy.models.contas;


@RestController
public class contaController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(contaController.class);

    List<contas> contaListas = new ArrayList<>();

    @GetMapping("/api/contas")
    public List<contas> index(){
        return contaListas;
    }

    @GetMapping("/api/contas/{id}")
    public ResponseEntity<contas> show(@PathVariable Long id){
        log.info("buscar id da conta " + id);
        var contaEncontrada = contaListas
                                        .stream()
                                        .filter((d) -> {return d.getId().equals(id);})
                                        .findFirst();

        if (contaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
            return ResponseEntity.ok(contaEncontrada.get());
    }

    @PostMapping("/api/contas")
    public ResponseEntity<contas> create(@RequestBody contas Contas){
        log.info("Cadastrar conta " + Contas);
        Contas.setId(contaListas.size()+ 1l);
        return ResponseEntity.status(HttpStatus.CREATED).body(Contas);

    }


    @DeleteMapping("/api/contas/{id}")
    public ResponseEntity<contas> destroy(@PathVariable Long id){
    log.info("Apagar conta com id" + id);
    var contaEncontrada = contaListas
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (contaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        contaListas.remove(contaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

     @PutMapping("/api/contas/{id}")
    public ResponseEntity<contas> update(@PathVariable Long id, @RequestBody contas Conta){
        log.info("apagar despesa com id " + id);
        var contaEncontrada = contaListas
                                    .stream()
                                    .filter((d) -> {return d.getId().equals(id);})
                                    .findFirst();

        if (contaEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        contaListas.remove(contaEncontrada.get());
        Conta.setId(id);
        contaListas.add(Conta);
            
        return ResponseEntity.ok(Conta);
    }



}



