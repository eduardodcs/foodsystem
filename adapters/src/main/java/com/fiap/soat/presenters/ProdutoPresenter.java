package com.fiap.soat.presenters;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.domain.entities.Produto;
import com.fiap.soat.dtos.CategoriaResponse;
import com.fiap.soat.dtos.ProdutoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPresenter {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoResponse toProdutoResponse(Produto produto) {
        CategoriaResponse categoriaResponse = modelMapper.map(produto.getCategoria(), CategoriaResponse.class);
        ProdutoResponse produtoResponse = modelMapper.map(produto, ProdutoResponse.class);
        produtoResponse.setCategoriaResponse(categoriaResponse);
        return produtoResponse;
    }
}
