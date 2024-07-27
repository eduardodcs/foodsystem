package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentMethod {
    private String type;
    private Pix pix;
}
