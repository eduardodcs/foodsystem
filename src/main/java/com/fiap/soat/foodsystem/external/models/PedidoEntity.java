package com.fiap.soat.foodsystem.external.models;

import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "Pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cliente_id")
    private Long cliente_id;
    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_Cliente_Pedido"), updatable = false, insertable = false)
    private ClienteEntity cliente;
    @OneToMany(mappedBy = "pedido_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoProdutoEntity> listaPedidoProdutos = new ArrayList<>();
    private StatusPedido statusPedido;
    private BigDecimal valorTotal;
    @Column(length = 500)
    private String observacao;
    private LocalDateTime dataHoraCriacao;
    @OneToMany(mappedBy="pedido")
    private List<PagamentoEntity> pagamentos = new ArrayList<>();

}
