package com.fiap.soat.foodsystem.adapters.gateways.gateways;

import com.fiap.soat.foodsystem.adapters.gateways.client.IPagamentoClient;
import com.fiap.soat.foodsystem.adapters.gateways.datasource.IPagamentoDataSource;
import com.fiap.soat.foodsystem.adapters.mapper.PagamentoMapper;
import com.fiap.soat.foodsystem.adapters.presenters.PagamentoPresenter;
import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IPagamentoGateway;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoGatewayImpl implements IPagamentoGateway {

    @Autowired
    private IPagamentoClient pagamentoClient;

    @Autowired
    private IPagamentoDataSource pagamentoDataSource;

    @Autowired
    private PagamentoPresenter pagamentoPresenter;

    @Autowired
    PagamentoMapper pagamentoMapper;

    @Override
    public Pagamento gerarSolicitacaoPagamento(Pagamento pagamento) {
        JsonObject jsonPagBank = pagamentoPresenter.obterJsonPagBank(pagamento);
        JsonObject pagamentoResponse = pagamentoClient.gerarSolicitacaoPagamento(jsonPagBank);
        return pagamentoMapper.jsonResponseToPagamento(pagamentoResponse);
    }

    @Override
    public Pagamento consultarStatusPagamento(Long pedidoId) {
        return pagamentoDataSource.findByPedidoId(pedidoId);
    }

    @Override
    public Pagamento atualizarPagamento(Pagamento pagamento) {

        return pagamentoDataSource.update(pagamento);
    }
}
