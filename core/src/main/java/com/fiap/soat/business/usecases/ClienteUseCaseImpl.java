package com.fiap.soat.business.usecases;

import com.fiap.soat.business.interfaces.gateways.IClienteGateway;
import com.fiap.soat.business.interfaces.usecases.IClienteUseCase;
import com.fiap.soat.domain.entities.Cliente;
import com.fiap.soat.exceptions.BusinessException;
import com.fiap.soat.exceptions.NotFoundException;

import java.util.List;

public class ClienteUseCaseImpl implements IClienteUseCase {

    private IClienteGateway clienteGateway;

    public ClienteUseCaseImpl(IClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente findById(Long id) {
        Cliente cliente = clienteGateway.findById(id);
        if (cliente == null) {
            throw new NotFoundException("Cliente não encontrado para o id " + id);
        }
        return cliente;
    }

    @Override
    public Cliente findByCpf(String cpf) {
        Cliente cliente = clienteGateway.findByCpf(cpf);
        if (cliente == null) {
            throw new NotFoundException("Cliente não encontrado para o CPF " + cpf);
        }
        return clienteGateway.findByCpf(cpf);
    }

    @Override
    public Cliente save(Cliente cliente) {
        if (clienteGateway.existsByCpf(cliente.getCpf())){
            throw new BusinessException("Cliente já cadastrado para o CPF informado.");
        }
        if (clienteGateway.existsByEmail(cliente.getEmail())){
            throw new BusinessException("Cliente já cadastrado para o email informado.");
        }
        cliente.setId(null);
        cliente.setStatusAtivo(true);
        return clienteGateway.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        Cliente clienteOriginal = clienteGateway.findById(cliente.getId());
        if(!clienteOriginal.getCpf().equals(cliente.getCpf())){
            throw new BusinessException("Não é permitido alterar o campo CPF.");
        }
        return clienteGateway.update(cliente);
    }

    @Override
    public void delete(String cpf) {
        Cliente cliente = clienteGateway.findByCpf(cpf);
        cliente.setStatusAtivo(false);
        clienteGateway.delete(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteGateway.findAll();
    }
}
