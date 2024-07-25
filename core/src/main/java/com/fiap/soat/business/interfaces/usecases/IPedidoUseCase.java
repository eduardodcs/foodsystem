package com.fiap.soat.business.interfaces.usecases;

import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.enums.StatusPedido;

import java.util.List;

public interface IPedidoUseCase {

    Pedido findById(Long id);
    List<Pedido> findAll();
    Pedido save(Pedido pedido);
    void cancel(Long id);
    Pedido update(Pedido pedido);
    List<Pedido> findByStatus(Integer status);
}
