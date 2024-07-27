package com.fiap.soat.foodsystem.core.business.interfaces.gateways;

import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;

public interface IPagamentoGateway {

    Pagamento gerarSolicitacaoPagamento(Pagamento pagamento);
    Pagamento consultarStatusPagamento(Long pedidoId);
    Pagamento atualizarPagamento(Pagamento pagamento);

}
