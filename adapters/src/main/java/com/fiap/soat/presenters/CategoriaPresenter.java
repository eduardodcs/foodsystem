package com.fiap.soat.presenters;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.dtos.CategoriaResponse;
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
