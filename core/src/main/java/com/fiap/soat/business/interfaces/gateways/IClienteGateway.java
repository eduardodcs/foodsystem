package com.fiap.soat.business.interfaces.gateways;

import com.fiap.soat.domain.entities.Cliente;

import java.util.List;

public interface IClienteGateway {
    Cliente findById(Long id);
    Cliente findByCpf(String cpf);
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(Cliente cliente);
    List<Cliente> findAll();
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
