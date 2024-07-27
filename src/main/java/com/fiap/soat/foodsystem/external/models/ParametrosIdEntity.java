package com.fiap.soat.foodsystem.external.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
public class ParametrosIdEntity {

    private String grupo;
    private String parametro;

}
