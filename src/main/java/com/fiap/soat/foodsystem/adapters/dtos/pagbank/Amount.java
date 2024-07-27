package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Amount {
    private int value;
    private String currency;
    private Summary summary;
}
