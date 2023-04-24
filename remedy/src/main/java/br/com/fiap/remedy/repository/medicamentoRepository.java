package br.com.fiap.remedy.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.remedy.models.Medicamento;

public interface medicamentoRepository extends JpaRepository<Medicamento, Long> {

    Page<Medicamento> findByDescricaoContaining(String busca, org.springframework.data.domain.Pageable pageable);

    Page<Medicamento> findAll(Pageable pageable);

    
}
