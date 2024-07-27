package com.fiap.soat.foodsystem.adapters.mapper;


import com.fiap.soat.foodsystem.adapters.dtos.PedidoReceived;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IClienteUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IProdutoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Cliente;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.entities.PedidoProduto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    public Pedido pedidoReceivedToPedido(IProdutoUseCase produtoUseCase,
                                         IClienteUseCase clienteUseCase, PedidoReceived pedidoReceived) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoReceived.getId());
        List<PedidoProduto> pedidoProdutoList = pedidoReceived.getListaPedidoProduto().stream().map(item -> {
            PedidoProduto pedidoProduto = new PedidoProduto();
            pedidoProduto.setProduto(produtoUseCase.findById(item.getIdProduto()));
            pedidoProduto.setQtdeProduto(item.getQtdeProduto());
            pedidoProduto.setPrecoUnitario(item.getPrecoUnitario());
            pedidoProduto.setSubTotal(item.getSubTotal());
            return pedidoProduto;
        }).toList();
        Cliente cliente = clienteUseCase.findById(pedidoReceived.getIdCliente());
        pedido.setCliente(cliente);
        pedido.setListaPedidoProdutos(pedidoProdutoList);
        pedido.setValorTotalPedido(pedidoReceived.getValorTotal());
        pedido.setObservacao(pedidoReceived.getObservacao());
        return pedido;
    }

}
