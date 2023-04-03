package br.com.fiap.remedy.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ser um campo nulo")
    @Pattern(regexp="[a-zA-Z ]+", message="O nome do medicamento deve conter apenas letras e espaços")
    private String nome;

    @NotNull(message = "Dosagem não pode ser um campo nulo")
    @Pattern(regexp="[0-9]+(?<=[a-zA-Z])", message="a dosagem do medicamento deve conter apenas letras e números")
    private Double dosagem;


    @NotNull(message = "Início não pode ser um campo nulo")
    @Pattern(regexp="[0-9]", message="O início do tratamento deve conter apenas números")
    private LocalDate inicio;

    @NotNull(message = "Fim não pode ser um campo nulo")
    @Pattern(regexp="[0-9]", message="O fim do tratamento deve conter apenas números")
    private LocalDate fim;
    
    @NotNull(message = "Hora não pode ser um campo nulo")
    @Pattern(regexp="[0-9]", message="A hora do medicamento deve conter apenas números")
    private LocalTime hora; 


    protected medicamento(){};
    
    public medicamento(String nome, Double dosagem, LocalDate inicio, LocalDate fim, LocalTime hora, Double preco) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.inicio = inicio;
        this.fim = fim;
        this.hora = hora;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getDosagem() {
        return dosagem;
    }
    public void setDosagem(Double dosagem) {
        this.dosagem = dosagem;
    }
    public LocalDate getInicio() {
        return inicio;
    }
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
    public LocalDate getFim() {
        return fim;
    }
    public void setFim(LocalDate fim) {
        this.fim = fim;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    private Double preco;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "medicamento [nome=" + nome + ", dosagem=" + dosagem + ", inicio=" + inicio + ", fim=" + fim + ", hora="
                + hora + ", preco=" + preco + "]";
    }
}
