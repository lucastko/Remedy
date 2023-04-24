package br.com.fiap.remedy.repository;


import br.com.fiap.remedy.models.Categoria;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface categoriaRepository extends JpaRepository<Categoria, Long> {

    Page<Categoria> findByDescricaoContaining(String busca, org.springframework.data.domain.Pageable pageable);

    Page<Categoria> findAll(Pageable pageable);
}
