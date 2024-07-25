package com.fiap.soat.converters;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.domain.entities.Produto;
import com.fiap.soat.models.CategoriaEntity;
import com.fiap.soat.models.ProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConvert {

    @Autowired
    private ModelMapper modelMapper;

    public Produto produtoEntityToProduto(ProdutoEntity produtoEntity) {
        Categoria categoria = modelMapper.map(produtoEntity.getCategoria(), Categoria.class);
        Produto produto = modelMapper.map(produtoEntity, Produto.class);
        produto.setCategoria(categoria);
        return produto;
    }

    public ProdutoEntity produtoToProdutoEntity(Produto produto) {
        CategoriaEntity categoriaEntity = modelMapper.map(produto.getCategoria(), CategoriaEntity.class);
        ProdutoEntity produtoEntity = modelMapper.map(produto, ProdutoEntity.class);
        produtoEntity.setCategoria(categoriaEntity);
        return produtoEntity;
    }
}
