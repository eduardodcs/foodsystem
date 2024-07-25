package com.fiap.soat.mapper;

import com.fiap.soat.business.interfaces.usecases.IClienteUseCase;
import com.fiap.soat.business.interfaces.usecases.IProdutoUseCase;
import com.fiap.soat.domain.entities.Cliente;
import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.entities.PedidoProduto;
import com.fiap.soat.dtos.PedidoReceived;
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
            pedidoProduto.setQtdeProduto(pedidoProduto.getQtdeProduto());
            pedidoProduto.setPrecoUnitario(pedidoProduto.getPrecoUnitario());
            pedidoProduto.setSubTotal(pedidoProduto.getSubTotal());
            return pedidoProduto;
        }).toList();
        Cliente cliente = clienteUseCase.findById(pedidoReceived.getIdCliente());
        pedido.setCliente(cliente);
        pedido.setListaPedidoProdutos(pedidoProdutoList);
        pedido.setValorTotalPedido(pedido.getValorTotalPedido());
        pedido.setObservacao(pedido.getObservacao());
        return pedido;
    }

}
