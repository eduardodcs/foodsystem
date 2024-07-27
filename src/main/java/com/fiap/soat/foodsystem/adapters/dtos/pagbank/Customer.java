package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer {
    private String name;
    private String email;
    @SerializedName("tax_id")
    private String taxId;
}
