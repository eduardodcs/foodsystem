package com.fiap.soat.foodsystem.adapters.gateways.datasource;


import com.fiap.soat.foodsystem.core.domain.entities.Categoria;

import java.util.List;

public interface ICategoriaDataSource {
    Categoria getCategoriaById(Long id);
    List<Categoria> getAllCategorias();
    Categoria saveCategoria(Categoria categoria);
    void deleteCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
}
