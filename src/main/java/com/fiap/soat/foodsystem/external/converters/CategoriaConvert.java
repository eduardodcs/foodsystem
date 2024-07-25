package com.fiap.soat.foodsystem.external.converters;


import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.external.models.CategoriaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConvert {

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaEntity categoriaToCategoriaEntity(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaEntity.class);
    }

    public Categoria categoriaEntityToCategoria(CategoriaEntity categoriaEntity) {
        return modelMapper.map(categoriaEntity, Categoria.class);
    }

}