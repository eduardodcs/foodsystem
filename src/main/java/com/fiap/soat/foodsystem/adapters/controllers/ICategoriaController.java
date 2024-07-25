package com.fiap.soat.foodsystem.adapters.controllers;

import com.fiap.soat.foodsystem.adapters.dtos.CategoriaReceived;
import com.fiap.soat.foodsystem.adapters.dtos.CategoriaResponse;

import java.util.List;

public interface ICategoriaController {

    CategoriaResponse getCategoriaById(Long id);
    List<CategoriaResponse> getAllCategorias();
    CategoriaResponse saveCategoria(CategoriaReceived categoriaReceived);
    void deleteCategoria(Long id);
    CategoriaResponse updateCategoria(CategoriaReceived categoriaReceived);

}
