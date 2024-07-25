package com.fiap.soat.foodsystem.adapters.gateways.gateways;


import com.fiap.soat.foodsystem.adapters.gateways.datasource.IClienteDataSource;
import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IClienteGateway;
import com.fiap.soat.foodsystem.core.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGatewayImpl implements IClienteGateway {

    @Autowired
    private IClienteDataSource clienteDataSource;

    @Override
    public Cliente findById(Long id) {
        return clienteDataSource.findById(id);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return clienteDataSource.findByCpf(cpf);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDataSource.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteDataSource.update(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDataSource.delete(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteDataSource.findAll();
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return clienteDataSource.existsByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(String email) {
        return clienteDataSource.existsByEmail(email);
    }
}
