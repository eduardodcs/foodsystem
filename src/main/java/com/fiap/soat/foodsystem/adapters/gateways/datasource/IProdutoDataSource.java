package com.fiap.soat.foodsystem.adapters.gateways.datasource;


import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;

import java.util.List;

public interface IProdutoDataSource {
    Produto findById(Long id);
    List<Produto> findAll();
    List<Produto> findByCategoriaId(Categoria categoria);
    Produto save(Produto produto);
    Produto update(Produto produto);
    void delete(Produto produto);
}
