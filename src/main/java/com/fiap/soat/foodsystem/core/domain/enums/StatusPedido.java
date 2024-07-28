package com.fiap.soat.foodsystem.core.domain.enums;

import com.fiap.soat.foodsystem.core.exceptions.BusinessException;

import java.util.Arrays;

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

    public static StatusPedido getByValue(Integer value){
        return Arrays.stream(StatusPedido.values()).filter(e -> e.ordinal() == value)
                .findAny().orElseThrow(() -> new BusinessException("O status informado é inválido."));
    }
}

