package com.fiap.soat.mapper;

import com.fiap.soat.domain.entities.Cliente;
import com.fiap.soat.dtos.ClienteReceived;
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
