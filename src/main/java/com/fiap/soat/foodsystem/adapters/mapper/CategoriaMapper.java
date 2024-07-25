package com.fiap.soat.foodsystem.adapters.mapper;


import com.fiap.soat.foodsystem.adapters.dtos.CategoriaReceived;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Categoria toCategoria(CategoriaReceived categoriaReceived) {
        return modelMapper.map(categoriaReceived, Categoria.class);
    }
}
