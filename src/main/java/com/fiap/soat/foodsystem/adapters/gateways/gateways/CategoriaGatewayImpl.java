package com.fiap.soat.foodsystem.adapters.gateways.gateways;

import com.fiap.soat.foodsystem.adapters.gateways.datasource.ICategoriaDataSource;

import com.fiap.soat.foodsystem.core.business.interfaces.gateways.ICategoriaGateway;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaGatewayImpl implements ICategoriaGateway {

    @Autowired
    private ICategoriaDataSource categoriaDataSource;

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaDataSource.getCategoriaById(id);
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaDataSource.getAllCategorias();
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaDataSource.saveCategoria(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoriaDataSource.deleteCategoria(categoria);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return categoriaDataSource.updateCategoria(categoria);
    }
}
