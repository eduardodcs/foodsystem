package com.fiap.soat.foodsystem.core.business.usecases;

import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IProdutoGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.ICategoriaUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IProdutoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;
import com.fiap.soat.foodsystem.core.exceptions.BusinessException;
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
        if (id == null) {
            throw new NotFoundException("Id não pode ser nulo");
        }
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
        validarCampos(produto);
        produto.setId(null);
        produto.setStatusAtivo(true);
        produto.setDataHoraCriacao(LocalDateTime.now());
        return produtoGateway.save(produto);
    }

    private void validarCampos(Produto produto) {
        if (!produto.getCategoria().isStatusAtivo()) {
            throw new BusinessException("Não é permitido cadastrar produto com uma categoria inativa.");
        }
    }

    @Override
    public Produto update(Produto produto) {
        Produto produtoOriginal = findById(produto.getId());
        validarCamposUpdate(produto, produtoOriginal);
        produtoOriginal.setStatusAtivo(produto.isStatusAtivo());
        produtoOriginal.setCategoria(produto.getCategoria());
        produtoOriginal.setNome(produto.getNome());
        produtoOriginal.setDescricao(produto.getDescricao());
        produtoOriginal.setPreco(produto.getPreco());
        return produtoGateway.update(produtoOriginal);
    }

    private static void validarCamposUpdate(Produto produto, Produto produtoOriginal) {
        if (!produto.getCategoria().equals(produtoOriginal.getCategoria())
            && !produto.getCategoria().isStatusAtivo()) {
            throw new BusinessException("Não é permitido alterar para uma categoria inativa.");
        }
    }

    @Override
    public void delete(Long id) {
        Produto produtoOriginal = findById(id);
        produtoOriginal.setStatusAtivo(false);
        produtoGateway.delete(produtoOriginal);
    }

}
