package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Link {
    private String rel;
    private String href;
    private String media;
    private String type;
}
