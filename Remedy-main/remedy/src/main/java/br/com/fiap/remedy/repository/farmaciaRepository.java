package br.com.fiap.remedy.repository;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.remedy.models.Farmacia;

public interface farmaciaRepository extends JpaRepository<Farmacia, Long> {

    Page<Farmacia> findByDescricaoContaining(String busca, org.springframework.data.domain.Pageable pageable);

    Page<Farmacia> findAll(Pageable pageable);

    
}
