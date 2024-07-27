package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentResponse {
    private String code;
    private String message;
}
