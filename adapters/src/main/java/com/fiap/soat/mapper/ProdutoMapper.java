package com.fiap.soat.mapper;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.domain.entities.Produto;
import com.fiap.soat.dtos.ProdutoReceived;
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
