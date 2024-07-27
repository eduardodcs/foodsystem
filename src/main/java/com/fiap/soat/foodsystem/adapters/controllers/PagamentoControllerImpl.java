package com.fiap.soat.foodsystem.adapters.controllers;

import com.fiap.soat.foodsystem.adapters.dtos.PagamentoResponse;
import com.fiap.soat.foodsystem.adapters.dtos.pagbank.OrderResponse;
import com.fiap.soat.foodsystem.adapters.mapper.PagamentoMapper;
import com.fiap.soat.foodsystem.adapters.presenters.PagamentoPresenter;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPagamentoUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPedidoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoControllerImpl implements IPagamentoController{

    @Autowired
    private IPagamentoUseCase pagamentoUseCase;

    @Autowired
    private IPedidoUseCase pedidoUseCase;

    @Autowired
    private PagamentoMapper pagamentoMapper;
    @Autowired
    private PagamentoPresenter pagamentoPresenter;

    @Override
    public void callbackPagamentoPagBank(Long pedidoId, OrderResponse orderResponse) {
        Pedido pedido = pedidoUseCase.findById(pedidoId);
        Pagamento pagamento = pedido.getPagamentos().get(0);
        pagamentoMapper.orderResponseToPagamento(pedido, orderResponse);
        pagamentoUseCase.atualizarPagamento(pagamento);
    }

    @Override
    public PagamentoResponse consultaStatus(Long pedidoId) {
        Pedido pedido = pedidoUseCase.findById(pedidoId);
        Pagamento pagamento = pagamentoUseCase.consultarStatusPagamento(pedidoId);
        return pagamentoPresenter.pagamentoToPagamentoResponse(pagamento);
    }
}
