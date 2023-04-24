package br.com.fiap.remedy.models;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.data.domain.Pageable;

import br.com.fiap.remedy.controller.farmaciaController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
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

public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomeFarmacia;
    @NotNull
    private String ruaFarmacia;
    
    @NotNull
    @Min(value = 0, message = "O número da rua deve ser positivo")
    private int numeroFarmacia;
    @NotNull
    private String telefoneFarmacia;
    @NotNull
    private String horarioFarmacia;

    @ManyToOne
    private Conta conta;

    public  EntityModel<Farmacia> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(farmaciaController.class).show(id)).withSelfRel(),
            linkTo(methodOn(farmaciaController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(farmaciaController.class).index(Pageable.unpaged(), null)).withRel("listAll")
        );
    }
    
}
