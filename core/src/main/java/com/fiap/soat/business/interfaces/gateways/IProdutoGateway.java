package com.fiap.soat.business.interfaces.gateways;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.domain.entities.Produto;

import java.util.List;

public interface IProdutoGateway {
    Produto findById(Long id);
    List<Produto> findAll();
    List<Produto> findByCategoriaId(Categoria categoria);
    Produto save(Produto produto);
    Produto update(Produto produto);
    void delete(Produto produto);
}
