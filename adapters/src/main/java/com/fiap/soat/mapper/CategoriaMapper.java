package com.fiap.soat.mapper;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.dtos.CategoriaReceived;
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
