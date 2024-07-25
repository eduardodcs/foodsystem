package com.fiap.soat.foodsystem.external.datasources;


import com.fiap.soat.foodsystem.adapters.gateways.datasource.ICategoriaDataSource;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.external.converters.CategoriaConvert;
import com.fiap.soat.foodsystem.external.models.CategoriaEntity;
import com.fiap.soat.foodsystem.external.repositories.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaDataSourceImpl implements ICategoriaDataSource {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaConvert categoriaConvert;

    @Override
    public Categoria getCategoriaById(Long id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id).stream()
                .map(categoriaEntity -> categoriaConvert.categoriaEntityToCategoria(categoriaEntity)).findAny();
        return optionalCategoria.orElse(null);

    }

    @Override
    public List<Categoria> getAllCategorias() {
        List<CategoriaEntity> list = categoriaRepository.findAll();
        return list.stream()
                .map(categoriaEntity -> categoriaConvert.categoriaEntityToCategoria(categoriaEntity)).toList();
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaConvert.categoriaToCategoriaEntity(categoria);
        CategoriaEntity saved = categoriaRepository.save(categoriaEntity);
        return categoriaConvert.categoriaEntityToCategoria(saved);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        saveCategoria(categoria);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return saveCategoria(categoria);
    }
}
