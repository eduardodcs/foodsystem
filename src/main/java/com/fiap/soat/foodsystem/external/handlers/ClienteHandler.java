package com.fiap.soat.foodsystem.external.handlers;

import com.fiap.soat.foodsystem.adapters.controllers.ClienteControllerImpl;
import com.fiap.soat.foodsystem.adapters.dtos.ClienteReceived;
import com.fiap.soat.foodsystem.adapters.dtos.ClienteResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteHandler {

    @Autowired
    private ClienteControllerImpl clienteController;

    @GetMapping("/{cpf}")
//    @Tag(name = "Cliente")
//    @Operation(summary = "Buscar Cliente pelo CPF")
    public ResponseEntity<ClienteResponse> buscarClientePorCpf(@Valid @PathVariable String cpf) {
        ClienteResponse clienteResponse = clienteController.findByCpf(cpf);
        return ResponseEntity.ok(clienteResponse);
    }

    @GetMapping("/id/{id}")
//    @Tag(name = "Cliente")
//    @Operation(summary = "Buscar Cliente pelo Id")
    public ResponseEntity<ClienteResponse> buscarClientePeloId(@Valid @PathVariable Long id) {
        ClienteResponse clienteResponse = clienteController.findById(id);
        return ResponseEntity.ok(clienteResponse);
    }

    @GetMapping()
//    @Tag(name = "Cliente")
//    @Operation(summary = "Listar todos os clientes")
    public ResponseEntity<List<ClienteResponse>> buscarClientes() {
        List<ClienteResponse> clienteResponses = clienteController.findAll();
        return ResponseEntity.ok(clienteResponses);
    }


    @PostMapping
//    @Tag(name = "Cliente")
//    @Operation(summary = "Cadastrar Cliente")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Validated @RequestBody ClienteReceived clienteReceived) {
        ClienteResponse clienteResponse = clienteController.save(clienteReceived);
        return ResponseEntity.ok(clienteResponse);
    }

    @PutMapping
//    @Tag(name = "Cliente")
//    @Operation(summary = "Atualizar dados de Cliente")
    public ResponseEntity<ClienteResponse> atualizarDadosCliente(@Validated @RequestBody ClienteReceived clienteReceived) {
        ClienteResponse clienteResponse = clienteController.update(clienteReceived);
        return ResponseEntity.ok(clienteResponse);
    }

    @DeleteMapping("/{cpf}")
//    @Tag(name = "Cliente")
//    @Operation(summary = "Excluir cadastro do Cliente")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirCliente(@Valid @PathVariable String cpf) {
        clienteController.delete(cpf);
    }
}
