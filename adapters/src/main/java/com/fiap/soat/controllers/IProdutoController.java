package com.fiap.soat.controllers;

import com.fiap.soat.dtos.ProdutoReceived;
import com.fiap.soat.dtos.ProdutoResponse;

import java.util.List;

public interface IProdutoController {

    ProdutoResponse findById(Long id);
    List<ProdutoResponse> findByCategoriaId(Long categoriaId);
    List<ProdutoResponse> findAll ();
    ProdutoResponse save(ProdutoReceived produtoReceived);
    ProdutoResponse update(ProdutoReceived produtoReceived);
    void delete(Long id);

}
