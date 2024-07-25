package com.fiap.soat.foodsystem.adapters.presenters;


import com.fiap.soat.foodsystem.adapters.dtos.ClienteResponse;
import com.fiap.soat.foodsystem.core.domain.entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientePresenter {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteResponse toClienteResponse(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponse.class);
    }

}
