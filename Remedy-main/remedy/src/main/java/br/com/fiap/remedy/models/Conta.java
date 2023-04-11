package br.com.fiap.remedy.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String senha;

    @OneToMany(mappedBy = "conta")
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "conta")
    private List<Farmacia> farmacias = new ArrayList<>();

    @OneToMany(mappedBy = "conta")
    private List<Medicamento> medicamentos = new ArrayList<>();
}
