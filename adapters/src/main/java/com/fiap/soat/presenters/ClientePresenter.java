package com.fiap.soat.presenters;

import com.fiap.soat.domain.entities.Cliente;
import com.fiap.soat.dtos.ClienteResponse;
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
