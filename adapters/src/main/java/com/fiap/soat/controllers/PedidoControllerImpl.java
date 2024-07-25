package com.fiap.soat.controllers;

import com.fiap.soat.business.interfaces.usecases.IClienteUseCase;
import com.fiap.soat.business.interfaces.usecases.IPedidoUseCase;
import com.fiap.soat.business.interfaces.usecases.IProdutoUseCase;
import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.enums.StatusPedido;
import com.fiap.soat.dtos.PedidoReceived;
import com.fiap.soat.dtos.PedidoResponse;
import com.fiap.soat.mapper.PedidoMapper;
import com.fiap.soat.presenters.PedidoPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoControllerImpl implements IPedidoController {

    @Autowired
    private IPedidoUseCase pedidoUseCase;

    @Autowired
    private IClienteUseCase clienteUseCase;

    @Autowired
    private IProdutoUseCase produtoUseCase;

    @Autowired
    private PedidoPresenter pedidoPresenter;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public PedidoResponse findById(Long id) {
        Pedido pedido = pedidoUseCase.findById(id);
        return pedidoPresenter.toPedidoResponse(pedido);
    }

    @Override
    public List<PedidoResponse> findAll() {
        List<Pedido> pedidos = pedidoUseCase.findAll();
        return pedidos.stream().map(pedido -> pedidoPresenter.toPedidoResponse(pedido)).toList();
    }

    @Override
    public PedidoResponse save(PedidoReceived pedidoReceived) {
        Pedido pedido = pedidoMapper.pedidoReceivedToPedido(produtoUseCase, clienteUseCase, pedidoReceived);
        return pedidoPresenter.toPedidoResponse(pedidoUseCase.save(pedido));
    }

    @Override
    public void cancel(Long id) {
        pedidoUseCase.cancel(id);
    }

    @Override
    public PedidoResponse update(PedidoReceived pedidoReceived) {
        Pedido pedido = pedidoMapper.pedidoReceivedToPedido(produtoUseCase, clienteUseCase, pedidoReceived);
        return pedidoPresenter.toPedidoResponse(pedidoUseCase.update(pedido));
    }

    @Override
    public List<PedidoResponse> findByStatus(Integer status) {
        List<Pedido> pedidos = pedidoUseCase.findByStatus(status);
        return pedidos.stream().map(pedido -> pedidoPresenter.toPedidoResponse(pedido)).toList();
    }

}
