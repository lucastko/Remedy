package br.com.fiap.remedy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.remedy.models.Farmacia;

public interface farmaciaRepository extends JpaRepository<Farmacia, Long> {

    
}
