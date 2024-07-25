package com.fiap.soat.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteResponse {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private boolean statusAtivo;
}
