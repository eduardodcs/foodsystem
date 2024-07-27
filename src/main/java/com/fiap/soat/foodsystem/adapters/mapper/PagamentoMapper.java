package com.fiap.soat.foodsystem.adapters.mapper;

import com.fiap.soat.foodsystem.adapters.dtos.pagbank.OrderResponse;
import com.fiap.soat.foodsystem.adapters.utils.JsonObjectProcessor;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    @Autowired
    private JsonObjectProcessor processor;

    public Pagamento jsonResponseToPagamento(JsonObject jsonResponse) {
        OrderResponse orderResponse = processor.processJsonObject(jsonResponse, OrderResponse.class);
        Pagamento pagamento = new Pagamento();
        pagamento.setQrcodeLink(orderResponse.getQrCodes().get(0).getLinks().get(0).getHref().toString());
        pagamento.setQrcodeText(orderResponse.getQrCodes().get(0).getText());
        pagamento.setIdentificador(orderResponse.getId());
        return pagamento;
    }

    public void orderResponseToPagamento(Pedido pedido, OrderResponse orderResponse) {
        if ("PAID".equals(orderResponse.getCharges().get(0).getStatus())){
            pedido.getPagamentos().get(0).setQrcodeLink(orderResponse.getQrCodes().get(0).getLinks().get(0).getHref().toString());
            pedido.getPagamentos().get(0).setQrcodeText(orderResponse.getQrCodes().get(0).getText());
            pedido.getPagamentos().get(0).setIdentificador(orderResponse.getId());
            pedido.getPagamentos().get(0).setStatusPagamento(StatusPagamento.FINALIZADO);
        } else {
            pedido.getPagamentos().get(0).setStatusPagamento(StatusPagamento.RECUSADO);
        }
    }






}


