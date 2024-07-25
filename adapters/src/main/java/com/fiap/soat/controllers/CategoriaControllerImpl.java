package com.fiap.soat.controllers;

import com.fiap.soat.business.interfaces.usecases.ICategoriaUseCase;
import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.dtos.CategoriaReceived;
import com.fiap.soat.dtos.CategoriaResponse;
import com.fiap.soat.mapper.CategoriaMapper;
import com.fiap.soat.presenters.CategoriaPresenter;
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
