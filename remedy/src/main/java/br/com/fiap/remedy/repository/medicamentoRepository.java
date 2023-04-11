package br.com.fiap.remedy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.remedy.models.Medicamento;

public interface medicamentoRepository extends JpaRepository<Medicamento, Long> {
    
}
