package br.com.fiap.remedy.models;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.remedy.controller.categoriaController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Categoria {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomeCategoria;
    @NotNull
    
    private String tipoCategoria;
    @NotNull

    private String principioAtivo;
    
    @NotNull
    private String descricao;


    @ManyToOne
    private Conta conta;


    public EntityModel<Categoria> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(categoriaController.class).show(id)).withSelfRel(),
            linkTo(methodOn(categoriaController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(categoriaController.class).index(Pageable.unpaged(), null)).withRel("listAll")
        );
    }
}
