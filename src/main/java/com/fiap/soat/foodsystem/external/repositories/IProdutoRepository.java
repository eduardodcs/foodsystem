package com.fiap.soat.foodsystem.external.repositories;

import com.fiap.soat.foodsystem.external.models.CategoriaEntity;
import com.fiap.soat.foodsystem.external.models.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findByCategoria(CategoriaEntity categoria);
}
