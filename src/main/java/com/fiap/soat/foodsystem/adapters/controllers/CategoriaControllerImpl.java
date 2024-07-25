package com.fiap.soat.foodsystem.adapters.controllers;


import com.fiap.soat.foodsystem.adapters.dtos.CategoriaReceived;
import com.fiap.soat.foodsystem.adapters.dtos.CategoriaResponse;
import com.fiap.soat.foodsystem.adapters.mapper.CategoriaMapper;
import com.fiap.soat.foodsystem.adapters.presenters.CategoriaPresenter;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.ICategoriaUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaControllerImpl implements ICategoriaController{

    @Autowired
    private ICategoriaUseCase categoriaUseCase;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private CategoriaPresenter categoriaPresenter;

    @Override
    public CategoriaResponse getCategoriaById(Long id) {
        Categoria categoria = categoriaUseCase.getCategoriaById(id);
        return categoriaPresenter.toCategoriaResponse(categoria);
    }

    @Override
    public List<CategoriaResponse> getAllCategorias() {
        List<Categoria> categorias = categoriaUseCase.getAllCategorias();
        return categorias.stream().map(categoria -> categoriaPresenter.toCategoriaResponse(categoria)).toList();
    }

    @Override
    public CategoriaResponse saveCategoria(CategoriaReceived categoriaReceived) {
        Categoria categoria = categoriaMapper.toCategoria(categoriaReceived);
        Categoria categoriaSaved = categoriaUseCase.createCategoria(categoria);
        return categoriaPresenter.toCategoriaResponse(categoriaSaved);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaUseCase.deleteCategoria(id);
    }

    @Override
    public CategoriaResponse updateCategoria(CategoriaReceived categoriaReceived) {
        Categoria categoria = categoriaMapper.toCategoria(categoriaReceived);
        Categoria categoriaUpdated = categoriaUseCase.updateCategoria(categoria);
        return categoriaPresenter.toCategoriaResponse(categoriaUpdated);
    }
}
