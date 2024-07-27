package com.fiap.soat.foodsystem.core.business.interfaces.usecases;

import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;

public interface IPagamentoUseCase {

    Pagamento gerarPagamento(Pedido pedido);
    Pagamento consultarStatusPagamento(Pagamento pagamento);
    Pagamento atualizarPagamento(Pagamento pagamento);

}
