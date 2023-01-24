package com.estudos.estudos.domain.repository;

import com.estudos.estudos.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Categoria findByNome(String nome);
}
