package com.fiap.soat.gateways.datasource;

import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.enums.StatusPedido;

import java.util.List;

public interface IPedidoDataSource {
    Pedido findById(Long id);
    List<Pedido> findAll();
    Pedido save(Pedido pedido);
    void cancel(Pedido pedido);
    Pedido update(Pedido pedido);
    List<Pedido> findByStatus(StatusPedido status);
}
