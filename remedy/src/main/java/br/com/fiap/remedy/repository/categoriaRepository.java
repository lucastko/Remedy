package br.com.fiap.remedy.repository;


import br.com.fiap.remedy.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface categoriaRepository extends JpaRepository<Categoria, Long> {

    
}
