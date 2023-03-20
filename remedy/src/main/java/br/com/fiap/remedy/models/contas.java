package br.com.fiap.remedy.models;

public class contas {
    
    private String nome;
    private String email;
    private String senha;
    private Long id;

    public contas(String nome, String email, String senha) {
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
