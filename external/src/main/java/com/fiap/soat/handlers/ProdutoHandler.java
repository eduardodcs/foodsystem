package com.fiap.soat.handlers;

import com.fiap.soat.controllers.IProdutoController;
import com.fiap.soat.dtos.ProdutoReceived;
import com.fiap.soat.dtos.ProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoHandler {

    @Autowired
    private IProdutoController produtoController;

    @GetMapping("categoria/{categoriaId}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar lista de produtos disponíveis por categoria")
    public ResponseEntity<List<ProdutoResponse>> buscarProdutosPorCategoria(@PathVariable Long categoriaId) {
        List<ProdutoResponse> listaProduto = this.produtoController.findByCategoriaId(categoriaId);
        return ResponseEntity.ok(listaProduto);
    }

    @GetMapping("{id}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar produto por Id")
    public ResponseEntity<ProdutoResponse> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoResponse produtoResponse = produtoController.findById(id);
        return ResponseEntity.ok(produtoResponse);
    }

    @PutMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Editar cadastro de produto")
    public ResponseEntity<ProdutoResponse> editarProduto(@Valid @RequestBody ProdutoReceived produtoReceived) {
        return ResponseEntity.ok(produtoController.update(produtoReceived));
    }

    @PostMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Cadastrar produto")
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@Valid @RequestBody ProdutoReceived produtoReceived) {
        return ResponseEntity.ok(produtoController.save(produtoReceived));
    }

    @PutMapping("/inativar/{id}")
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Ativar / Inativar produto")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void inativarProduto(@PathVariable Long id) {
        produtoController.delete(id);
    }

}
