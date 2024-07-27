package com.fiap.soat.foodsystem.adapters.controllers;

import com.fiap.soat.foodsystem.adapters.dtos.PagamentoResponse;
import com.fiap.soat.foodsystem.adapters.dtos.pagbank.OrderResponse;

public interface IPagamentoController {

    void callbackPagamentoPagBank(Long pedidoId, OrderResponse orderResponse);

    PagamentoResponse consultaStatus(Long pedidoId);
}
