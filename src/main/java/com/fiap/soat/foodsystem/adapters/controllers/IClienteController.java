package com.fiap.soat.foodsystem.adapters.controllers;


import com.fiap.soat.foodsystem.adapters.dtos.ClienteReceived;
import com.fiap.soat.foodsystem.adapters.dtos.ClienteResponse;

import java.util.List;

public interface IClienteController {
    ClienteResponse findById(Long id);
    ClienteResponse findByCpf(String cpf);
    ClienteResponse save(ClienteReceived clienteReceived);
    ClienteResponse update(ClienteReceived clienteReceived);
    void delete(String cpf);
    List<ClienteResponse> findAll();
}
