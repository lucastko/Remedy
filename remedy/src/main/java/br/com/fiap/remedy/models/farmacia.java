package br.com.fiap.remedy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        
    @NotNull(message = "Nome da farmácia não pode ser um campo nulo")
    @Pattern(regexp="[a-zA-Z ]+", message="O nome da farmácia deve conter apenas letras e espaços")
    private String nomeFarmacia;

        
    @NotNull(message = "Rua não pode ser um campo nulo")
    @Pattern(regexp="[a-zA-Z ]+", message="O nome da rua deve conter apenas letras e espaços")
    private String ruaFarmacia;

        
    @NotNull(message = "número não pode ser um campo nulo")
    @Pattern(regexp="[0-9]+", message="O número da farmácia deve conter apenas números")
    private int numeroFarmacia;

    @NotNull(message = "Telefone não pode ser um campo nulo")
    @Pattern(regexp="[0-9]+", message="O telefone da farmácia deve conter apenas números")
    private String telefoneFarmacia;

    @NotNull(message = "Horário não pode ser um campo nulo")
    @Pattern(regexp="[0-9]+", message="O horário da farmácia deve conter apenas números")
    private String horarioFarmacia;



    @Override
    public String toString() {
        return "farmacia [nomeFarmacia=" + nomeFarmacia + ", ruaFarmacia=" + ruaFarmacia + ", numeroFarmacia="
                + numeroFarmacia + ", telefoneFarmacia=" + telefoneFarmacia + ", horarioFarmacia=" + horarioFarmacia
                + "]";
    }



    protected farmacia(){};

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
