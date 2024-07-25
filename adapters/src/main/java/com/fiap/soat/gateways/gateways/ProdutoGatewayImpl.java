package com.fiap.soat.gateways.gateways;

import com.fiap.soat.business.interfaces.gateways.IProdutoGateway;
import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.domain.entities.Produto;
import com.fiap.soat.gateways.datasource.IProdutoDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGatewayImpl implements IProdutoGateway {

    @Autowired
    private IProdutoDataSource produtoDataSource;

    @Override
    public Produto findById(Long id) {
        return produtoDataSource.findById(id);
    }

    @Override
    public List<Produto> findAll() {
        return produtoDataSource.findAll();
    }

    @Override
    public List<Produto> findByCategoriaId(Categoria categoria) {
        return produtoDataSource.findByCategoriaId(categoria);
    }

    @Override
    public Produto save(Produto produto) {
        return produtoDataSource.save(produto);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoDataSource.update(produto);
    }

    @Override
    public void delete(Produto produto) {
        produtoDataSource.delete(produto);
    }
}
