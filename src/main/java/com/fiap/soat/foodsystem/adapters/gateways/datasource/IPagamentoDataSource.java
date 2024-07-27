package com.fiap.soat.foodsystem.adapters.gateways.datasource;

import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;

public interface IPagamentoDataSource {

    Pagamento save(Pagamento pagamento);
    Pagamento findByPedidoId(Long pedidoId);
    Pagamento update(Pagamento pagamento);
}
