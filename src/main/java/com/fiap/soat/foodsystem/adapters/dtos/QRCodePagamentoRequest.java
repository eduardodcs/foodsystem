package com.fiap.soat.foodsystem.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QRCodePagamentoRequest {

    private BigDecimal amount = BigDecimal.ZERO;
//    private LocalDateTime expiration_date;
    private String expiration_date = "2024-07-27T20:15:59-03:00";

    public void setAmount(BigDecimal amount) {
        this.amount = amount.setScale(2, RoundingMode.HALF_EVEN);;
    }

}
