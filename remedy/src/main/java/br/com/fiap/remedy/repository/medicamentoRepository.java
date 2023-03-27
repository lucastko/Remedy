package br.com.fiap.remedy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.remedy.models.medicamento;

public interface medicamentoRepository extends JpaRepository<medicamento, Long> {
    
}
