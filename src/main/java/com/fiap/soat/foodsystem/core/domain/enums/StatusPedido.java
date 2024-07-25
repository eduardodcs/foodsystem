package com.fiap.soat.foodsystem.core.domain.enums;

public enum StatusPedido {

    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em Preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado"),
    ;

    private String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

}

