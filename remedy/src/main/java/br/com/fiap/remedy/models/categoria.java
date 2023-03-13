package br.com.fiap.remedy.models;

public class categoria {

    private String nomeCategoria;
    private String tipoCategoria;
    private String principioAtivo;
    private String descricao;

    @Override
    public String toString() {
        return "categoria [nomeCategoria=" + nomeCategoria + ", tipoCategoria=" + tipoCategoria + ", principioAtivo="
                + principioAtivo + ", descricao=" + descricao + "]";
    }

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
    
    

}
