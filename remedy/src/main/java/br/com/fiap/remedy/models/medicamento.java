package br.com.fiap.remedy.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double dosagem;
    private LocalDate inicio;
    private LocalDate fim;
    private LocalTime hora; 


    
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
