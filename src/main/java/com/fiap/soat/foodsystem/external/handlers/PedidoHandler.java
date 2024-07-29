package com.fiap.soat.foodsystem.external.handlers;


import com.fiap.soat.foodsystem.adapters.controllers.IPedidoController;
import com.fiap.soat.foodsystem.adapters.dtos.PedidoReceived;
import com.fiap.soat.foodsystem.adapters.dtos.PedidoResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoHandler {

    @Autowired
    private IPedidoController pedidoController;

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> getAllPedidos() {
        List<PedidoResponse> all = pedidoController.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    @Transactional
//    @Tag(name = "Pedido")
//    @Operation(summary = "Salvar pedido")
    public ResponseEntity<PedidoResponse> salvarPedido(@RequestBody @Valid PedidoReceived pedidoReceived){
        PedidoResponse pedidoResponse = pedidoController.save(pedidoReceived);
        return ResponseEntity.ok(pedidoResponse);
    }

    @GetMapping("{id}")
//    @Tag(name = "Pedido")
//    @Operation(summary = "Buscar pedido por Id")
    public ResponseEntity<PedidoResponse> buscarPedidoPorId(@PathVariable("id") Long id){
        PedidoResponse pedidoResponse = pedidoController.findById(id);
        return ResponseEntity.ok(pedidoResponse);
    }

    @GetMapping("/status/{status}")
//    @Tag(name = "Pedido")
//    @Operation(summary = "Buscar pedido por status")
    public ResponseEntity<List<PedidoResponse>> buscarPedidosPorStatus(@PathVariable("status") Integer status){
        List<PedidoResponse> pedidoResponses = pedidoController.findByStatus(status);
        return ResponseEntity.ok(pedidoResponses);
    }

    @PutMapping
    @Transactional
//    @Tag(name = "Pedido")
//    @Operation(summary = "Atualizar pedido")
    public ResponseEntity<PedidoResponse> atualizarPedido(@RequestBody @Valid PedidoReceived pedidoReceived){
        PedidoResponse pedidoResponse = pedidoController.update(pedidoReceived);
        return ResponseEntity.ok(pedidoResponse);
    }


    @PutMapping("{id}")
    @Transactional
//    @Tag(name = "Pedido")
//    @Operation(summary = "Cancelar pedido")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarPedido(@PathVariable("id") Long id){
        pedidoController.cancel(id);
    }

    @PutMapping("alterar-status/{pedidoId}/{status}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarStatus(@PathVariable("pedidoId") Long pedidoId, @PathVariable("status") Integer status){
        pedidoController.atualizarStatus(pedidoId, status);
    }
}
