package com.fiap.soat.gateways.datasource;

import com.fiap.soat.domain.entities.Categoria;

import java.util.List;

public interface ICategoriaDataSource {
    Categoria getCategoriaById(Long id);
    List<Categoria> getAllCategorias();
    Categoria saveCategoria(Categoria categoria);
    void deleteCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
}
