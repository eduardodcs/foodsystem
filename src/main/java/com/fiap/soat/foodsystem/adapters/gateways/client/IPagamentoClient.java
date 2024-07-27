package com.fiap.soat.foodsystem.adapters.gateways.client;

import com.google.gson.JsonObject;

public interface IPagamentoClient {

    JsonObject gerarSolicitacaoPagamento(JsonObject jsonPagamentoRequest);
}
