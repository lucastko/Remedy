package br.com.fiap.remedy.models;

import java.util.Optional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class categoria {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome da categoria não pode ser um campo vazio.")
    @Pattern(regexp ="[a-zA-Z ]+", message = "O nome da categoria deve conter apenas letras e espaços." )
    private String nomeCategoria;

    @NotNull(message = "Tipo da categoria não pode ser um campo vazio.")
    @Pattern(regexp ="[a-zA-Z ]+", message = "O tipo da categoria deve conter apenas letras e espaços." )
    private String tipoCategoria;

    @NotNull(message = "Principio Ativo não pode ser um campo vazio.")
    @Pattern(regexp ="[a-zA-Z ]+", message = "O principio ativo deve conter apenas letras e espaços." )
    private String principioAtivo;

    @NotNull(message = "A descrição da categoria não pode ser um campo vazio.")
    @Pattern(regexp ="[a-zA-Z ]+", message = "A descrição da categoria deve conter apenas letras e espaços." )
    private String descricao;



    @Override
    public String toString() {
        return "categoria [nomeCategoria=" + nomeCategoria + ", tipoCategoria=" + tipoCategoria + ", principioAtivo="
                + principioAtivo + ", descricao=" + descricao + "]";
    }


    protected categoria(){}


    public categoria(String nomeCategoria, String tipoCategoria, String principioAtivo, String descricao) {
        this.nomeCategoria = nomeCategoria;
        this.tipoCategoria = tipoCategoria;
        this.principioAtivo = principioAtivo;
        this.descricao = descricao;
    }


    public String getNomeCategoria() {
        return nomeCategoria;
    }
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    public String getTipoCategoria() {
        return tipoCategoria;
    }
    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
    public String getPrincipioAtivo() {
        return principioAtivo;
    }
    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Optional<categoria> stream() {
        return null;
    }
    
    

}
