package com.fiap.soat.foodsystem.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoProdutoResponse {
    private ProdutoResponse produto;
    private Integer qtdeProduto;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;
}
