package com.fiap.soat.controllers;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.dtos.CategoriaReceived;
import com.fiap.soat.dtos.CategoriaResponse;

import java.util.List;

public interface ICategoriaController {

    CategoriaResponse getCategoriaById(Long id);
    List<CategoriaResponse> getAllCategorias();
    CategoriaResponse saveCategoria(CategoriaReceived categoriaReceived);
    void deleteCategoria(Long id);
    CategoriaResponse updateCategoria(CategoriaReceived categoriaReceived);

}
