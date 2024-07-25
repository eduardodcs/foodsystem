package com.fiap.soat.foodsystem.adapters.controllers;

import com.fiap.soat.foodsystem.adapters.dtos.ProdutoReceived;
import com.fiap.soat.foodsystem.adapters.dtos.ProdutoResponse;

import java.util.List;

public interface IProdutoController {

    ProdutoResponse findById(Long id);
    List<ProdutoResponse> findByCategoriaId(Long categoriaId);
    List<ProdutoResponse> findAll ();
    ProdutoResponse save(ProdutoReceived produtoReceived);
    ProdutoResponse update(ProdutoReceived produtoReceived);
    void delete(Long id);

}
