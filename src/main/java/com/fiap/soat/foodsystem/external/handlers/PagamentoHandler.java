package com.fiap.soat.foodsystem.external.handlers;

import com.fiap.soat.foodsystem.adapters.controllers.IPagamentoController;
import com.fiap.soat.foodsystem.adapters.dtos.pagbank.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pagamento")
public class PagamentoHandler {

    @Autowired
    private IPagamentoController pagamentoController;

    @PostMapping("callback/{pedidoId}")
    @Tag(name = "Pagamento")
    @Operation(summary = "Webhook callback de pagamentos")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void callback(@PathVariable("pedidoId") Long pedidoId, @RequestBody OrderResponse orderResponse) {
        System.out.println(orderResponse);
        pagamentoController.callbackPagamentoPagBank(pedidoId, orderResponse);
    }


}
