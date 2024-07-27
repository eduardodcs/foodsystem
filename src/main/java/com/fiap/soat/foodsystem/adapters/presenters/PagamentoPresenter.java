package com.fiap.soat.foodsystem.adapters.presenters;

import com.fiap.soat.foodsystem.adapters.dtos.PagamentoResponse;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class PagamentoPresenter {

    @Autowired
    private ModelMapper modelMapper;

//    String url = "https://en15o9sfeh7lc.x.pipedream.net/pagamento/callback/";
    String url = "https://distinct-monitor-topical.ngrok-free.app/pagamento/callback/";


    public PagamentoResponse pagamentoToPagamentoResponse(Pagamento pagamento) {
        return modelMapper.map(pagamento, PagamentoResponse.class);
    }



    public JsonObject obterJsonPagBank(Pagamento pagamento){

        JsonArray notification_urls = new JsonArray();
        notification_urls.add(url + pagamento.getPedido().getId());

        JsonObject customer = new JsonObject();
        customer.addProperty("name",pagamento.getPedido().getCliente().getNome());
        customer.addProperty("email", pagamento.getPedido().getCliente().getEmail());
        customer.addProperty("tax_id", pagamento.getPedido().getCliente().getCpf());

        JsonObject amount = new JsonObject();
        amount.addProperty("value", pagamento.getPedido().getValorTotalPedido());

        JsonObject qr_code = new JsonObject();
        qr_code.add("amount", amount);
        qr_code.addProperty("expiration_date", Instant.now().plus(1, ChronoUnit.DAYS).toString());

        JsonArray qr_codes = new JsonArray();
        qr_codes.add(qr_code);

        JsonObject order = new JsonObject();
        order.addProperty("reference_id", pagamento.getPedido().getId());
        order.add("notification_urls", notification_urls);
        order.add("customer", customer);
        order.add("qr_codes", qr_codes);

        return order;

    }
}
