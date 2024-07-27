package com.fiap.soat.foodsystem.core.business.usecases;

import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IPagamentoGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPagamentoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.TipoPagamento;

public class PagamentoUseCaseImpl implements IPagamentoUseCase {

    private IPagamentoGateway pagamentoGateway;

    public PagamentoUseCaseImpl(IPagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    @Override
    public Pagamento gerarPagamento(Pedido pedido) {
        Pagamento pagamento = new Pagamento(pedido);
        Pagamento pagamentoResponse = pagamentoGateway.gerarSolicitacaoPagamento(pagamento);
        pagamento.setId(pagamentoResponse.getId());
        pagamento.setIdentificador(pagamentoResponse.getIdentificador());
        pagamento.setQrcodeText(pagamentoResponse.getQrcodeText());
        pagamento.setQrcodeLink(pagamentoResponse.getQrcodeLink());
        pagamento.setTipoPagamento(TipoPagamento.PIX_QRCODE);
        pagamento.setInstituicao("PagBank");
        Pagamento saved = pagamentoGateway.atualizarPagamento(pagamento);
        return saved;
    }

    @Override
    public Pagamento consultarStatusPagamento(Pagamento pagamento) {
        return pagamentoGateway.consultarStatusPagamento(pagamento);
    }

    @Override
    public Pagamento atualizarPagamento(Pagamento pagamento) {
        return pagamentoGateway.atualizarPagamento(pagamento);
    }
}
