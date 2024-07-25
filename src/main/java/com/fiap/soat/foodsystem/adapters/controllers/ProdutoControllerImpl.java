package com.fiap.soat.foodsystem.adapters.controllers;

import com.fiap.soat.foodsystem.core.business.interfaces.usecases.ICategoriaUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IProdutoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;
import com.fiap.soat.foodsystem.adapters.dtos.ProdutoReceived;
import com.fiap.soat.foodsystem.adapters.dtos.ProdutoResponse;
import com.fiap.soat.foodsystem.adapters.mapper.ProdutoMapper;
import com.fiap.soat.foodsystem.adapters.presenters.ProdutoPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoControllerImpl implements IProdutoController{

    @Autowired
    public IProdutoUseCase produtoUseCase;

    @Autowired
    public ICategoriaUseCase categoriaUseCase;

    @Autowired
    public ProdutoMapper produtoMapper;

    @Autowired
    public ProdutoPresenter produtoPresenter;

    @Override
    public ProdutoResponse findById(Long id) {
        Produto produto = produtoUseCase.findById(id);
        return produtoPresenter.toProdutoResponse(produto);
    }

    @Override
    public List<ProdutoResponse> findByCategoriaId(Long categoriaId) {
        List<Produto> produtos = produtoUseCase.findByCategoriaId(categoriaId);
        return produtos.stream().map(produto -> produtoPresenter.toProdutoResponse(produto)).toList();
    }

    @Override
    public List<ProdutoResponse> findAll() {
        List<Produto> produtos = produtoUseCase.findAll();
        return produtos.stream().map(produto -> produtoPresenter.toProdutoResponse(produto)).toList();
    }

    @Override
    public ProdutoResponse save(ProdutoReceived produtoReceived) {
        Categoria categoria = categoriaUseCase.getCategoriaById(produtoReceived.getIdCategoria());
        Produto produto = produtoMapper.toProduto(produtoReceived);
        produto.setCategoria(categoria);
        Produto produtoSaved = produtoUseCase.save(produto);
        return produtoPresenter.toProdutoResponse(produtoSaved);
    }

    @Override
    public ProdutoResponse update(ProdutoReceived produtoReceived) {
        Categoria categoria = categoriaUseCase.getCategoriaById(produtoReceived.getIdCategoria());
        Produto produto = produtoMapper.toProduto(produtoReceived);
        produto.setCategoria(categoria);
        Produto produtoSaved = produtoUseCase.update(produto);
        return produtoPresenter.toProdutoResponse(produtoSaved);
    }

    @Override
    public void delete(Long id) {
        produtoUseCase.delete(id);
    }
}
