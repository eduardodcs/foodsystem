package com.fiap.soat.foodsystem.external.models;

import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.core.domain.enums.TipoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "Pagamento")
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="pedido_id", nullable=false)
    private PedidoEntity pedido;
    private String instituicao;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    private StatusPagamento statusPagamento;
    private String qrcodeLink;
    @Column(length = 500)
    private String qrcodeText;
    private String identificador;
    private LocalDateTime dataHoraAtualizacao;
}
