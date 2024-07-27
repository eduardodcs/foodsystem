package com.fiap.soat.foodsystem.core.business.usecases;

import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IPedidoGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPagamentoUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPedidoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.core.exceptions.BusinessException;
import com.fiap.soat.foodsystem.core.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PedidoUseCaseImpl implements IPedidoUseCase {

    private IPedidoGateway pedidoGateway;
    private IPagamentoUseCase pagamentoUseCase;

    public PedidoUseCaseImpl(IPedidoGateway pedidoGateway, IPagamentoUseCase pagamentoUseCase)  {
        this.pedidoGateway = pedidoGateway;
        this.pagamentoUseCase = pagamentoUseCase;
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
        Pedido pedidoSaved = pedidoGateway.save(pedido);
        pedidoSaved.setPagamentos(Arrays.asList(pagamentoUseCase.gerarPagamento(pedidoSaved)));
//        Pedido updated = update(pedidoSaved);
        return pedidoSaved;
    }

    @Override
    public void cancel(Long id) {
        Pedido pedido = findById(id);
        pedido.setStatusPedido(StatusPedido.CANCELADO);
        pedidoGateway.cancel(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        Pedido pedidoOriginal = findById(pedido.getId());
        if (!pedidoOriginal.getPagamentos().isEmpty()
                && (StatusPagamento.FINALIZADO.equals(pedidoOriginal.getPagamentos().get(0).getStatusPagamento()))) {
            throw new BusinessException("Não é possível alterar pedido com status de pagamento finalizado.");
        }
        return pedidoGateway.update(pedido);
    }

    @Override
    public List<Pedido> findByStatus(Integer status) {
        StatusPedido statusPedido = Arrays.stream(StatusPedido.values()).filter(e -> e.ordinal() == status)
                .findAny().orElseThrow(() -> new BusinessException("O status informado é inválido."));;
        return pedidoGateway.findByStatus(statusPedido);
    }
}
