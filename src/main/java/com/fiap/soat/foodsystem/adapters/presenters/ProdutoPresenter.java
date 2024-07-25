package com.fiap.soat.foodsystem.adapters.presenters;


import com.fiap.soat.foodsystem.adapters.dtos.CategoriaResponse;
import com.fiap.soat.foodsystem.adapters.dtos.ProdutoResponse;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;
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
