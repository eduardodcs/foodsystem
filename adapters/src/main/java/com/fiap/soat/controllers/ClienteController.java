package com.fiap.soat.controllers;

import com.fiap.soat.business.interfaces.usecases.IClienteUseCase;
import com.fiap.soat.domain.entities.Cliente;
import com.fiap.soat.dtos.ClienteReceived;
import com.fiap.soat.dtos.ClienteResponse;
import com.fiap.soat.mapper.ClienteMapper;
import com.fiap.soat.presenters.ClientePresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteController implements IClienteController{

    @Autowired
    private IClienteUseCase clienteUseCase;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClientePresenter clientePresenter;


    @Override
    public ClienteResponse findById(Long id) {
        Cliente cliente = clienteUseCase.findById(id);
        return clientePresenter.toClienteResponse(cliente);
    }

    @Override
    public ClienteResponse findByCpf(String cpf) {
        Cliente cliente = clienteUseCase.findByCpf(cpf);
        return clientePresenter.toClienteResponse(cliente);
    }

    @Override
    public ClienteResponse save(ClienteReceived clienteReceived) {
        Cliente cliente = clienteMapper.toCliente(clienteReceived);
        Cliente clienteSaved = clienteUseCase.save(cliente);
        return clientePresenter.toClienteResponse(clienteSaved);
    }

    @Override
    public ClienteResponse update(ClienteReceived clienteReceived) {
        Cliente cliente = clienteMapper.toCliente(clienteReceived);
        Cliente clienteUpdated = clienteUseCase.update(cliente);
        return clientePresenter.toClienteResponse(clienteUpdated);
    }

    @Override
    public void delete(String cpf) {
        clienteUseCase.delete(cpf);
    }

    @Override
    public List<ClienteResponse> findAll() {
        List<Cliente> clientes = clienteUseCase.findAll();
        return clientes.stream().map(cliente -> clientePresenter.toClienteResponse(cliente)).toList();
    }
}
