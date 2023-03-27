package br.com.fiap.remedy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nomeFarmacia;
    private String ruaFarmacia;
    private int numeroFarmacia;
    private String telefoneFarmacia;
    private String horarioFarmacia;
    private Long id;


    @Override
    public String toString() {
        return "farmacia [nomeFarmacia=" + nomeFarmacia + ", ruaFarmacia=" + ruaFarmacia + ", numeroFarmacia="
                + numeroFarmacia + ", telefoneFarmacia=" + telefoneFarmacia + ", horarioFarmacia=" + horarioFarmacia
                + "]";
    }


    


    public farmacia(String nomeFarmacia, String ruaFarmacia, int numeroFarmacia, String telefoneFarmacia,
            String horarioFarmacia) {
        this.nomeFarmacia = nomeFarmacia;
        this.ruaFarmacia = ruaFarmacia;
        this.numeroFarmacia = numeroFarmacia;
        this.telefoneFarmacia = telefoneFarmacia;
        this.horarioFarmacia = horarioFarmacia;
    }


    public String getNomeFarmacia() {
        return nomeFarmacia;
    }
    public void setNomeFarmacia(String nomeFarmacia) {
        this.nomeFarmacia = nomeFarmacia;
    }
    public String getRuaFarmacia() {
        return ruaFarmacia;
    }
    public void setRuaFarmacia(String ruaFarmacia) {
        this.ruaFarmacia = ruaFarmacia;
    }
    public int getNumeroFarmacia() {
        return numeroFarmacia;
    }
    public void setNumeroFarmacia(int numeroFarmacia) {
        this.numeroFarmacia = numeroFarmacia;
    }
    public String getTelefoneFarmacia() {
        return telefoneFarmacia;
    }
    public void setTelefoneFarmacia(String telefoneFarmacia) {
        this.telefoneFarmacia = telefoneFarmacia;
    }
    public String getHorarioFarmacia() {
        return horarioFarmacia;
    }
    public void setHorarioFarmacia(String horarioFarmacia) {
        this.horarioFarmacia = horarioFarmacia;
    }





    public Long getId() {
        return id;
    }





    public void setId(Long id) {
        this.id = id;
    }


}
