package com.fiap.soat.foodsystem.adapters.presenters;


import com.fiap.soat.foodsystem.adapters.dtos.CategoriaResponse;
import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaPresenter {

    @Autowired
    private ModelMapper modelMapper;


    public CategoriaResponse toCategoriaResponse(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaResponse.class);
    }
}
