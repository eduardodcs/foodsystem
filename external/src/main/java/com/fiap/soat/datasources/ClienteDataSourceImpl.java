package com.fiap.soat.datasources;

import com.fiap.soat.converters.ClienteConvert;
import com.fiap.soat.domain.entities.Cliente;
import com.fiap.soat.gateways.datasource.IClienteDataSource;
import com.fiap.soat.models.ClienteEntity;
import com.fiap.soat.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteDataSourceImpl implements IClienteDataSource {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteConvert clienteConvert;

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id).stream()
                .map(clienteEntity -> clienteConvert.clienteEntityToCliente(clienteEntity)).findAny();
        return optionalCliente.orElse(null);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).map(clienteEntity -> clienteConvert.clienteEntityToCliente(clienteEntity)).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity clienteEntity = clienteConvert.clienteToClienteEntity(cliente);
        ClienteEntity saved = clienteRepository.save(clienteEntity);
        return clienteConvert.clienteEntityToCliente(saved);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        List<ClienteEntity> clienteEntities = clienteRepository.findAll();
        List<Cliente> clientes = clienteEntities.stream().map(clienteEntity -> clienteConvert.clienteEntityToCliente(clienteEntity)).toList();
        return clientes;
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(String email) {
        return clienteRepository.existsByEmail(email);
    }
}
