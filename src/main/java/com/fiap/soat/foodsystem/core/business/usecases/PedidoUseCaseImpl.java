package com.fiap.soat.foodsystem.core.business.usecases;

import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IPedidoGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPagamentoUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPedidoUseCase;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.entities.PedidoProduto;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.core.exceptions.BusinessException;
import com.fiap.soat.foodsystem.core.exceptions.NotFoundException;

import java.math.BigDecimal;
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
        if (id == null) {
            throw new BusinessException("Id não pode ser nulo");
        }
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
        calcularSubTotalProduto(pedido);
        calcularTotalPedido(pedido);
        Pedido pedidoSaved = pedidoGateway.save(pedido);
        pedidoSaved.setPagamentos(Arrays.asList(pagamentoUseCase.gerarPagamento(pedidoSaved)));
        return pedidoSaved;
    }

    private static void calcularTotalPedido(Pedido pedido) {
        pedido.setValorTotalPedido(pedido.getListaPedidoProdutos().stream()
                .map(PedidoProduto::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    private static void calcularSubTotalProduto(Pedido pedido) {
        pedido.getListaPedidoProdutos().forEach(pedidoProduto ->
            pedidoProduto.setSubTotal(pedidoProduto.getPrecoUnitario()
                    .multiply(BigDecimal.valueOf(pedidoProduto.getQtdeProduto()))));
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
        calcularSubTotalProduto(pedido);
        calcularTotalPedido(pedido);
        pedidoGateway.deletePedidoProdutoByPedidoId(pedido.getId());
        return pedidoGateway.update(pedido);
    }

    @Override
    public List<Pedido> findByStatus(Integer statusValue) {
        StatusPedido statusPedido = StatusPedido.getByValue(statusValue);
        return pedidoGateway.findByStatus(statusPedido);
    }

    @Override
    public void alterarStatus(Long pedidoId, Integer statusValue) {
        StatusPedido statusPedido = StatusPedido.getByValue(statusValue);
        Pedido pedido = findById(pedidoId);
        pedido.setStatusPedido(statusPedido);
        pedidoGateway.update(pedido);
    }


}
