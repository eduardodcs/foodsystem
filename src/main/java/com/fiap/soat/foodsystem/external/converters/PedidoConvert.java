package com.fiap.soat.foodsystem.external.converters;


import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.entities.PedidoProduto;
import com.fiap.soat.foodsystem.external.models.ClienteEntity;
import com.fiap.soat.foodsystem.external.models.PagamentoEntity;
import com.fiap.soat.foodsystem.external.models.PedidoEntity;
import com.fiap.soat.foodsystem.external.models.PedidoProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoConvert {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteConvert clienteConvert;
    @Autowired
    private PedidoProdutoConvert pedidoProdutoConvert;

    @Autowired
    private PagamentoConverter pagamentoConverter;

    public PedidoEntity pedidoToPedidoEntity(Pedido pedido) {
        PedidoEntity pedidoEntity = modelMapper.map(pedido, PedidoEntity.class);
        ClienteEntity clienteEntity = clienteConvert.clienteToClienteEntity(pedido.getCliente());
        List<PedidoProdutoEntity> listaPedidoProdutoEntity = pedido.getListaPedidoProdutos().stream()
                .map(pedidoProduto -> pedidoProdutoConvert.pedidoProdutoToPedidoProdutoEntity(pedidoProduto, pedidoEntity)).toList();
        List<PagamentoEntity> listaPagamentosEntity = pedido.getPagamentos().stream().map(pagamento -> modelMapper.map(pagamento, PagamentoEntity.class)).toList();
        pedidoEntity.setCliente(clienteEntity);
        pedidoEntity.setCliente_id(clienteEntity.getId());
        pedidoEntity.setListaPedidoProdutos(listaPedidoProdutoEntity);
        pedidoEntity.setPagamentos(listaPagamentosEntity);
        return pedidoEntity;
    }

    public Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoEntity.getId());
        pedido.setCliente(clienteConvert.clienteEntityToCliente(pedidoEntity.getCliente()));
        pedido.setStatusPedido(pedidoEntity.getStatusPedido());
//        pedido.setStatusPagamento(pedidoEntity.getStatusPagamento());
        pedido.setPagamentos(pedidoEntity.getPagamentos().stream()
                .map(pagamentoEntity -> {
                    Pagamento pagamento = pagamentoConverter.pagamentoEntityToPagamento(pagamentoEntity);
                    pagamento.setPedido(pedido);
                    return pagamento;
                }).toList());

        pedido.setValorTotalPedido(pedidoEntity.getValorTotal());
        pedido.setDataHoraCriacao(pedidoEntity.getDataHoraCriacao());
        pedido.setObservacao(pedidoEntity.getObservacao());
        List<PedidoProduto> listaPedidoProduto = pedidoEntity.getListaPedidoProdutos().stream()
                .map(pedidoProdutoEntity -> pedidoProdutoConvert.pedidoProdutoEntityToPedidoProduto(pedidoProdutoEntity, pedido)).toList();
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return pedido;
    }

}
