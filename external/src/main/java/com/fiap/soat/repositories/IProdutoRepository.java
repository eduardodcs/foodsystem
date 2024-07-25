package com.fiap.soat.repositories;

import com.fiap.soat.models.CategoriaEntity;
import com.fiap.soat.models.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findByCategoria(CategoriaEntity categoria);
}
