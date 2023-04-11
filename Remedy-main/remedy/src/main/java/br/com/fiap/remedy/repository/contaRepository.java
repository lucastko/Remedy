package br.com.fiap.remedy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.remedy.models.Conta;

public interface contaRepository  extends JpaRepository<Conta, Long>{
    
}
