package br.com.fiap.remedy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.remedy.models.contas;

public interface contaRepository  extends JpaRepository<contas, Long>{
    
}
