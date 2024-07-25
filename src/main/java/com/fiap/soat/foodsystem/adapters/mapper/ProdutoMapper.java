package com.fiap.soat.foodsystem.adapters.mapper;

import com.fiap.soat.foodsystem.adapters.dtos.ProdutoReceived;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Produto toProduto(ProdutoReceived produtoReceived) {
        return modelMapper.map(produtoReceived, Produto.class);
    }
}
