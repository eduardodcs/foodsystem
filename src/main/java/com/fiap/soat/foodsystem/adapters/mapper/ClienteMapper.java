package com.fiap.soat.foodsystem.adapters.mapper;


import com.fiap.soat.foodsystem.adapters.dtos.ClienteReceived;
import com.fiap.soat.foodsystem.core.domain.entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente toCliente(ClienteReceived clienteReceived) {
        return modelMapper.map(clienteReceived, Cliente.class);
    };

}
