package com.fiap.soat.presenters;

import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.entities.Produto;
import com.fiap.soat.dtos.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoPresenter {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoResponse toPedidoResponse(Pedido pedido) {
        List<PedidoProdutoResponse> produtoResponseList = pedido.getListaPedidoProdutos().stream().map(produto -> {
            PedidoProdutoResponse produtoPedidoResponse = new PedidoProdutoResponse();
            produtoPedidoResponse.setProduto(modelMapper.map(produto.getProduto(), ProdutoResponse.class));
            CategoriaResponse categoriaResponse = modelMapper.map(produto.getProduto().getCategoria(), CategoriaResponse.class);
            produtoPedidoResponse.getProduto().setCategoriaResponse(categoriaResponse);
            produtoPedidoResponse.setQtdeProduto(produto.getQtdeProduto());
            produtoPedidoResponse.setPrecoUnitario(produto.getPrecoUnitario());
            produtoPedidoResponse.setSubTotal(produto.getSubTotal());
            return produtoPedidoResponse;
        }).toList();
        ClienteResponse clienteResponse = modelMapper.map(pedido.getCliente(), ClienteResponse.class);
        PedidoResponse pedidoResponse = modelMapper.map(pedido, PedidoResponse.class);
        pedidoResponse.setCliente(clienteResponse);
        pedidoResponse.setListaPedidoProduto(produtoResponseList);
        return pedidoResponse;
    }

}
