package br.com.fiap.remedy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
}
