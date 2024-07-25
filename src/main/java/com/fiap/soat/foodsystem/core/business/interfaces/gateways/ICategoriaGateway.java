package com.fiap.soat.foodsystem.core.business.interfaces.gateways;


import com.fiap.soat.foodsystem.core.domain.entities.Categoria;

import java.util.List;

public interface ICategoriaGateway {

    Categoria getCategoriaById(Long id);
    List<Categoria> getAllCategorias();
    Categoria saveCategoria(Categoria categoria);
    void deleteCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
}
