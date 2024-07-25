package com.fiap.soat.controllers;

import com.fiap.soat.dtos.ClienteReceived;
import com.fiap.soat.dtos.ClienteResponse;

import java.util.List;

public interface IClienteController {
    ClienteResponse findById(Long id);
    ClienteResponse findByCpf(String cpf);
    ClienteResponse save(ClienteReceived clienteReceived);
    ClienteResponse update(ClienteReceived clienteReceived);
    void delete(String cpf);
    List<ClienteResponse> findAll();
}
