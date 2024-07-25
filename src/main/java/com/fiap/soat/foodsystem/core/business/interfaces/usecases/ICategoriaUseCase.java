package com.fiap.soat.foodsystem.core.business.interfaces.usecases;


import com.fiap.soat.foodsystem.core.domain.entities.Categoria;

import java.util.List;

public interface ICategoriaUseCase {

    Categoria getCategoriaById(Long id);
    List<Categoria> getAllCategorias();
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
    void deleteCategoria(Long id);

}
