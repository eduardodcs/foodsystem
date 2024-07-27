package com.fiap.soat.foodsystem.adapters.dtos;

import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.core.domain.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagamentoResponse {
    private Long id;
    private String instituicao;
    private TipoPagamento tipoPagamento;
    private StatusPagamento statusPagamento;
    private String qrcodeLink;
    private String qrcodeText;
    private String identificador;
    private LocalDateTime dataHoraAtualizacao;
}
