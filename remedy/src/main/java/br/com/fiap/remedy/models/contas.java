package br.com.fiap.remedy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class contas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Nome não pode ser um campo nulo")
    @Pattern(regexp="[a-zA-Z ]+", message="O nome deve conter apenas letras e espaços")
    private String nome;


    @Email
    private String email;

    @NotNull(message = "Senha não pode ser um campo nulo")
    @Pattern(regexp="[0-9]+(?<=[a-zA-Z])", message="A senha deve conter letras e números")
    private String senha;

    protected contas(){};
    
    public contas(long l, String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

    @Override
    public String toString() {
        return "contas [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
    }


}
