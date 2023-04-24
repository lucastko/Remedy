package br.com.fiap.remedy.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@PageableDefault(size = 5) org.springframework.data.domain.Pageable pageable, @RequestParam(required = false) String busca){
        Page<Categoria> page = (busca == null) ?
            categoriaRepository.findAll(pageable) :
            categoriaRepository.findByDescricaoContaining(busca, pageable);
        
        return assembler.toModel(page.map(Categoria::toModel));
    }


    @GetMapping("{id}")
    public EntityModel<Categoria> show(@PathVariable Long id){
        log.info("buscar id da categoria " + id);
        var categoria = categoriaRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "categoria não encontrada")
        );
        return categoria.toModel();
    }


    @PostMapping
    public ResponseEntity<EntityModel<Categoria>> create(@RequestBody Categoria Categoria){
        log.info("Cadastrar categoria " + Categoria);
        categoriaRepository.save(Categoria);
        return ResponseEntity
                            .created(Categoria.toModel().getRequiredLink("self").toUri())
                            .body(Categoria.toModel());
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


