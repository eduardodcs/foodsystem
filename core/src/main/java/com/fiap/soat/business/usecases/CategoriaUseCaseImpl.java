package com.fiap.soat.business.usecases;

import com.fiap.soat.business.interfaces.gateways.ICategoriaGateway;
import com.fiap.soat.business.interfaces.usecases.ICategoriaUseCase;
import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.exceptions.NotFoundException;

import java.util.List;

public class CategoriaUseCaseImpl implements ICategoriaUseCase {

    private ICategoriaGateway categoriaGateway;

    public CategoriaUseCaseImpl(ICategoriaGateway categoriaGateway) {
        this.categoriaGateway = categoriaGateway;
    }


    @Override
    public Categoria getCategoriaById(Long id) {
        Categoria categoria = categoriaGateway.getCategoriaById(id);
        if (categoria == null) {
            throw new NotFoundException("Categoria não encontrada para o id " + id);
        }
        return categoria;
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaGateway.getAllCategorias();
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        categoria.setId(null);
        categoria.setStatusAtivo(true);
        return categoriaGateway.saveCategoria(categoria);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        Categoria categoriaOriginal = getCategoriaById(categoria.getId());
        categoriaOriginal.setStatusAtivo(categoria.isStatusAtivo());
        categoriaOriginal.setNome(categoria.getNome());
        return categoriaGateway.updateCategoria(categoriaOriginal);
    }

    @Override
    public void deleteCategoria(Long id) {
        Categoria categoriaOriginal = getCategoriaById(id);
        categoriaOriginal.setStatusAtivo(false);
        categoriaGateway.deleteCategoria(categoriaOriginal);
    }
}
