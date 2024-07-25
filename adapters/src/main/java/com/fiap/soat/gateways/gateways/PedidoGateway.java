package com.fiap.soat.gateways.gateways;

import com.fiap.soat.business.interfaces.gateways.IPedidoGateway;
import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.enums.StatusPedido;
import com.fiap.soat.gateways.datasource.IPedidoDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoGateway implements IPedidoGateway {

    @Autowired
    private IPedidoDataSource pedidoDataSource;

    @Override
    public Pedido findById(Long id) {
        return pedidoDataSource.findById(id);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoDataSource.findAll();
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoDataSource.save(pedido);
    }

    @Override
    public void cancel(Pedido pedido) {
        pedidoDataSource.cancel(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoDataSource.update(pedido);
    }

    @Override
    public List<Pedido> findByStatus(StatusPedido status) {
        return pedidoDataSource.findByStatus(status);
    }
}
