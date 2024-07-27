package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Summary {
    private int total;
    private int paid;
    private int refunded;
}
