package com.fiap.soat.foodsystem.external.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "Parametros_Config")
public class ParametrosEntity {

    @EmbeddedId
    @AttributeOverride(name = "parametros_id", column = @Column(name = "parametros_id"))
    private ParametrosIdEntity parametrosId;
    private String valor;

}
