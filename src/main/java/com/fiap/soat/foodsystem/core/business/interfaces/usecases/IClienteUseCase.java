package com.fiap.soat.foodsystem.core.business.interfaces.usecases;

import com.fiap.soat.foodsystem.core.domain.entities.Cliente;

import java.util.List;

public interface IClienteUseCase {

    Cliente findById(Long id);
    Cliente findByCpf(String cpf);
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(String cpf);
    List<Cliente> findAll();

}
