package com.fiap.soat.foodsystem.core.business.usecases;

import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IProdutoGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.ICategoriaUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IProdutoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;
import com.fiap.soat.foodsystem.core.exceptions.NotFoundException;


import java.time.LocalDateTime;
import java.util.List;

public class ProdutoUseCaseImpl implements IProdutoUseCase {

    private IProdutoGateway produtoGateway;

    private ICategoriaUseCase categoriaUseCase;

    public ProdutoUseCaseImpl(IProdutoGateway produtoGateway, ICategoriaUseCase categoriaUseCase) {
        this.produtoGateway = produtoGateway;
        this.categoriaUseCase = categoriaUseCase;
    }

    @Override
    public Produto findById(Long id) {
        Produto produto = produtoGateway.findById(id);
        if (produto == null) {
            throw new NotFoundException("Produto não encontrado para o id " + id);
        }
        return produto;
    }

    @Override
    public List<Produto> findAll() {
        return produtoGateway.findAll();
    }

    @Override
    public List<Produto> findByCategoriaId(Long id) {
        Categoria categoria = categoriaUseCase.getCategoriaById(id);
        List<Produto> produtos = produtoGateway.findByCategoriaId(categoria);
        return produtos;
    }

    @Override
    public Produto save(Produto produto) {
        produto.setId(null);
        produto.setStatusAtivo(true);
        produto.setDataHoraCriacao(LocalDateTime.now());
        return produtoGateway.save(produto);
    }

    @Override
    public Produto update(Produto produto) {
        findById(produto.getId());
        return produtoGateway.update(produto);
    }

    @Override
    public void delete(Long id) {
        Produto produtoOriginal = findById(id);
        produtoOriginal.setStatusAtivo(false);
        produtoGateway.delete(produtoOriginal);
    }
}
