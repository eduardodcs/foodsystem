package com.fiap.soat.foodsystem.external.converters;


import com.fiap.soat.foodsystem.core.domain.entities.Cliente;
import com.fiap.soat.foodsystem.external.models.ClienteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteConvert {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente clienteEntityToCliente(ClienteEntity clienteEntity) {
        return modelMapper.map(clienteEntity, Cliente.class);
    }

    public ClienteEntity clienteToClienteEntity(Cliente cliente) {
        return modelMapper.map(cliente, ClienteEntity.class);
    }

}
