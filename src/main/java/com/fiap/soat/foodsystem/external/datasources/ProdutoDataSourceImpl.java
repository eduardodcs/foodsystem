package com.fiap.soat.foodsystem.external.datasources;


import com.fiap.soat.foodsystem.adapters.gateways.datasource.IProdutoDataSource;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;
import com.fiap.soat.foodsystem.external.converters.CategoriaConvert;
import com.fiap.soat.foodsystem.external.converters.ProdutoConvert;
import com.fiap.soat.foodsystem.external.models.CategoriaEntity;
import com.fiap.soat.foodsystem.external.models.ProdutoEntity;
import com.fiap.soat.foodsystem.external.repositories.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoDataSourceImpl implements IProdutoDataSource {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private ProdutoConvert produtoConvert;

    @Autowired
    private CategoriaConvert categoriaConvert;

    @Override
    public Produto findById(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id).stream()
                .map(produto -> produtoConvert.produtoEntityToProduto(produto)).findAny();
        return optionalProduto.orElse(null);
    }

    @Override
    public List<Produto> findAll() {
        List<ProdutoEntity> list = produtoRepository.findAll();
        return list.stream().map(produtoEntity -> produtoConvert.produtoEntityToProduto(produtoEntity)).toList();
    }

    @Override
    public List<Produto> findByCategoriaId(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaConvert.categoriaToCategoriaEntity(categoria);
        List<ProdutoEntity> list = produtoRepository.findByCategoria(categoriaEntity);
        return list.stream().map(produtoEntity -> produtoConvert.produtoEntityToProduto(produtoEntity)).toList();
    }

    @Override
    public Produto save(Produto produto) {
        ProdutoEntity produtoEntity = produtoConvert.produtoToProdutoEntity(produto);
        produtoEntity = produtoRepository.save(produtoEntity);
        return produtoConvert.produtoEntityToProduto(produtoEntity);
    }

    @Override
    public Produto update(Produto produto) {
        return save(produto);
    }

    @Override
    public void delete(Produto produto) {
        save(produto);
    }
}
