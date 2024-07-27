package com.fiap.soat.foodsystem.adapters.dtos;


import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoResponse {

    private Long id;
    private ClienteResponse cliente;
    private List<PedidoProdutoResponse> listaPedidoProduto;
    private StatusPedido statusPedido;
    private BigDecimal valorTotal;
    private LocalDateTime dataHoraCriacao;
    private String observacao;
    private List<PagamentoResponse> pagamentos;
}
