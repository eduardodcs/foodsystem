package com.fiap.soat.foodsystem.core.business.interfaces.usecases;

import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;

import java.util.List;

public interface IPedidoUseCase {

    Pedido findById(Long id);
    List<Pedido> findAll();
    Pedido save(Pedido pedido);
    void cancel(Long id);
    Pedido update(Pedido pedido);
    List<Pedido> findByStatus(Integer status);
    void alterarStatus(Long pedidoId, Integer statusPedido);
}
