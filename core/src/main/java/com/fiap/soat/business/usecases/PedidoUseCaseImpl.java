package com.fiap.soat.business.usecases;

import com.fiap.soat.business.interfaces.gateways.IPedidoGateway;
import com.fiap.soat.business.interfaces.usecases.IPedidoUseCase;
import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.enums.StatusPedido;
import com.fiap.soat.exceptions.BusinessException;
import com.fiap.soat.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PedidoUseCaseImpl implements IPedidoUseCase {

    private IPedidoGateway pedidoGateway;

    public PedidoUseCaseImpl(IPedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public Pedido findById(Long id) {
        Pedido pedido = pedidoGateway.findById(id);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado para o id " + id);
        }
        return pedido;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoGateway.findAll();
    }

    @Override
    public Pedido save(Pedido pedido) {
        pedido.setId(null);
        pedido.setStatusPedido(StatusPedido.RECEBIDO);
        pedido.setDataHoraCriacao(LocalDateTime.now());
        if (pedido.getListaPedidoProdutos().isEmpty()) {
            throw new BusinessException("O pedido precisa ter pelo menos um produto.");
        }
        return pedidoGateway.save(pedido);
    }

    @Override
    public void cancel(Long id) {
        Pedido pedido = findById(id);
        pedido.setStatusPedido(StatusPedido.CANCELADO);
        pedidoGateway.cancel(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        findById(pedido.getId());
        return pedidoGateway.update(pedido);
    }

    @Override
    public List<Pedido> findByStatus(Integer status) {
        StatusPedido statusPedido = Arrays.stream(StatusPedido.values()).filter(e -> e.ordinal() == status)
                .findAny().orElseThrow(() -> new BusinessException("O status informado é inválido."));;
        return pedidoGateway.findByStatus(statusPedido);
    }
}
