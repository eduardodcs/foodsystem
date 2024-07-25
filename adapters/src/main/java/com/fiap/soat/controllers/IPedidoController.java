package com.fiap.soat.controllers;

import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.enums.StatusPedido;
import com.fiap.soat.dtos.PedidoReceived;
import com.fiap.soat.dtos.PedidoResponse;

import java.util.List;

public interface IPedidoController {

    PedidoResponse findById(Long id);
    List<PedidoResponse> findAll();
    PedidoResponse save(PedidoReceived pedidoReceived);
    void cancel(Long id);
    PedidoResponse update(PedidoReceived pedidoReceived);
    List<PedidoResponse> findByStatus(Integer status);
}
