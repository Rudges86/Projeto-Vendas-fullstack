package com.estudos.estudos.domain.repository;

import com.estudos.estudos.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
