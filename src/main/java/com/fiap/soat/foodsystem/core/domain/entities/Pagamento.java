package com.fiap.soat.foodsystem.core.domain.entities;

import com.fiap.soat.foodsystem.core.domain.enums.TipoPagamento;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPagamento;

import java.time.LocalDateTime;

public class Pagamento {

    private Long id;
    private Pedido pedido;
    private String instituicao;
    private TipoPagamento tipoPagamento;
    private StatusPagamento statusPagamento;
    private String qrcodeLink;
    private String qrcodeText;
    private String identificador;
    private LocalDateTime dataHoraAtualizacao;

    public Pagamento() {}

    public Pagamento(Pedido pedido) {
        this.pedido = pedido;
        this.statusPagamento = StatusPagamento.PENDENTE;
        this.qrcodeLink = null;
        this.qrcodeText = null;
        this.identificador = null;
        this.dataHoraAtualizacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }



    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDateTime getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }

    public void setDataHoraAtualizacao(LocalDateTime dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }

    public String getQrcodeLink() {
        return qrcodeLink;
    }

    public void setQrcodeLink(String qrcodeLink) {
        this.qrcodeLink = qrcodeLink;
    }

    public String getQrcodeText() {
        return qrcodeText;
    }

    public void setQrcodeText(String qrcodeText) {
        this.qrcodeText = qrcodeText;
    }
}
