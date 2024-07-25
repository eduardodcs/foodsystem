package com.fiap.soat.foodsystem.adapters.controllers;



import com.fiap.soat.foodsystem.adapters.dtos.PedidoReceived;
import com.fiap.soat.foodsystem.adapters.dtos.PedidoResponse;

import java.util.List;

public interface IPedidoController {

    PedidoResponse findById(Long id);
    List<PedidoResponse> findAll();
    PedidoResponse save(PedidoReceived pedidoReceived);
    void cancel(Long id);
    PedidoResponse update(PedidoReceived pedidoReceived);
    List<PedidoResponse> findByStatus(Integer status);
}
