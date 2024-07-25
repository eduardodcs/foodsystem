package com.fiap.soat.foodsystem.adapters.gateways.datasource;



import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;

import java.util.List;

public interface IPedidoDataSource {
    Pedido findById(Long id);
    List<Pedido> findAll();
    Pedido save(Pedido pedido);
    void cancel(Pedido pedido);
    Pedido update(Pedido pedido);
    List<Pedido> findByStatus(StatusPedido status);
}
