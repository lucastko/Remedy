package br.com.fiap.remedy.controller;



import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    medicamentoRepository medicamentorepository;

    @Autowired
    contaRepository ContaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<org.springframework.hateoas.EntityModel<Object>> index(@PageableDefault(size = 5) org.springframework.data.domain.Pageable pageable, @RequestParam(required = false) String busca){
        Page<Medicamento> page = (busca == null) ?
            medicamentorepository.findAll(pageable) :
            medicamentorepository.findByDescricaoContaining(busca, pageable);
        
        return assembler.toModel(page.map(Medicamento::toModel));
    }

    @GetMapping("{id}")
    public EntityModel<Medicamento> show(@PathVariable Long id){
        log.info("buscar id do medicamento " + id);
        var Medicamento = medicamentorepository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("medicamento não encontrado"));
            
            return Medicamento.toModel();
    }

    @PostMapping("{id}")
    public ResponseEntity<EntityModel<Medicamento>> create(@RequestBody Medicamento Medicamento){
        log.info("Cadastrar medicamento " + Medicamento);
        medicamentorepository.save(Medicamento);
        return ResponseEntity
                            .created(Medicamento.toModel().getRequiredLink("self").toUri())
                            .body(Medicamento.toModel());

    }


    @DeleteMapping("{id}")
    public ResponseEntity<Medicamento> destroy(@PathVariable Long id){
    log.info("Apagar medicamento com id" + id);
    var medicamentoEncontrado = medicamentorepository.findById(id)
    .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, medicamento não encontrado"));

    medicamentorepository.delete(medicamentoEncontrado);

            return ResponseEntity.noContent().build();

    }

     @PutMapping("{id}")
        public ResponseEntity<Medicamento> update(@PathVariable Long id, @RequestBody @Valid Medicamento medicamento, BindingResult result){
        log.info("atualizar medicamento " + id);
        var medicamentoEncontrado = medicamentorepository.findById(id);

        if (medicamentoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        var novoMedicamento = medicamentoEncontrado.get();
        BeanUtils.copyProperties(medicamento, novoMedicamento, "id");
            
        return ResponseEntity.ok(novoMedicamento);
    }

    }

