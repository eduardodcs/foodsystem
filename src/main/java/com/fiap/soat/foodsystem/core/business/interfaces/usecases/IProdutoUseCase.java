package com.fiap.soat.foodsystem.core.business.interfaces.usecases;


import com.fiap.soat.foodsystem.core.domain.entities.Produto;

import java.util.List;

public interface IProdutoUseCase {
    Produto findById(Long id);
    List<Produto> findAll();
    List<Produto> findByCategoriaId(Long id);
    Produto save(Produto produto);
    Produto update(Produto produto);
    void delete(Long id);
}
