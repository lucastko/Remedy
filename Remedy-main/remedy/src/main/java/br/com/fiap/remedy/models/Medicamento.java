package br.com.fiap.remedy.models;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull    
    private String nome;
    @NotNull
    @Min(value = 0, message = "O valor do dosagem não pode ser negativo.")
    private Double dosagem;
    @NotNull
    private LocalDate inicio;
    @NotNull
    private LocalDate fim;
    @NotNull
    private LocalTime hora; 

    @ManyToOne
    private Conta conta;

}
