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
import br.com.fiap.remedy.models.Farmacia;
import br.com.fiap.remedy.repository.contaRepository;
import br.com.fiap.remedy.repository.farmaciaRepository;
import jakarta.validation.Valid;


@RequestMapping("/api/farmacia")
@RestController
public class farmaciaController {
    
    org.slf4j.Logger log = LoggerFactory.getLogger(farmaciaController.class);

    @Autowired
    farmaciaRepository farmaciaRepository;

    @Autowired
    contaRepository ContaRepository;

    
    @Autowired
    PagedResourcesAssembler<Object> assembler;



    @GetMapping
    public PagedModel<EntityModel<Object>> index(@PageableDefault(size = 5) org.springframework.data.domain.Pageable pageable, @RequestParam(required = false) String busca){
        Page<Farmacia> page = (busca == null) ?
            farmaciaRepository.findAll(pageable) :
            farmaciaRepository.findByDescricaoContaining(busca, pageable);
        
        return assembler.toModel(page.map(Farmacia::toModel));
    }

    @GetMapping("{id}")
    public EntityModel<Farmacia> show(@PathVariable Long id){
        log.info("buscar id da farmacia " + id);
        var Farmacia = farmaciaRepository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("farmácia não encontrada"));
            
            return Farmacia.toModel();
    }

    @PostMapping
    public ResponseEntity<EntityModel<Farmacia>> create(@RequestBody Farmacia Farmacia){
        log.info("Cadastrar farmacia " + Farmacia);
        farmaciaRepository.save(Farmacia);
        return ResponseEntity     
                            .created(Farmacia.toModel().getRequiredLink("self").toUri())
                            .body(Farmacia.toModel());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Farmacia> destroy(@PathVariable Long id){
    log.info("Apagar farmacia com id" + id);
    var farmaciaEncontrada = farmaciaRepository.findById(id)
    .orElseThrow(() -> new RestNotFoundException("Erro ao deletar, farmácia não encontrada"));

    farmaciaRepository.delete(farmaciaEncontrada);
            return ResponseEntity.noContent().build();

    }

     @PutMapping("{id}")
    public ResponseEntity<Farmacia> update(@PathVariable Long id, @RequestBody @Valid Farmacia farmacia, BindingResult result){
        log.info("atualizar farmácia " + id);
        var farmaciaEncontrada = farmaciaRepository.findById(id);
        
        if (farmaciaEncontrada.isEmpty()) return ResponseEntity.notFound().build();

        var novaFarmacia = farmaciaEncontrada.get();
        BeanUtils.copyProperties(farmacia, novaFarmacia, "id");
      
        farmaciaRepository.save(novaFarmacia);

        return ResponseEntity.ok(novaFarmacia);
    }


    
}


