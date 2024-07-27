package com.fiap.soat.foodsystem.external.handlers;


import com.fiap.soat.foodsystem.adapters.controllers.ICategoriaController;
import com.fiap.soat.foodsystem.adapters.dtos.CategoriaReceived;
import com.fiap.soat.foodsystem.adapters.dtos.CategoriaResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("categoria")
public class CategoriaHandler {

    @Autowired
    private ICategoriaController categoriaController;

    @GetMapping()
//    @Tag(name = "Categoria")
//    @Operation(summary = "Buscar lista de categorias disponíveis")
    public ResponseEntity<List<CategoriaResponse>> buscarCategorias() {
        List<CategoriaResponse> allCategorias = categoriaController.getAllCategorias();
        return ResponseEntity.ok(allCategorias);
    }

    @GetMapping("{id}")
//    @Tag(name = "Categoria")
//    @Operation(summary = "Buscar categoria por Id")
    public ResponseEntity<CategoriaResponse> buscarCategoriaPorId(@PathVariable Long id) {
        CategoriaResponse categoriaById = categoriaController.getCategoriaById(id);
        return ResponseEntity.ok(categoriaById);
    }

    @PutMapping
    @Transactional
//    @Tag(name = "Categoria")
//    @Operation(summary = "Editar cadastro de categoria")
    public ResponseEntity<CategoriaResponse> editarCategoria(@Valid @RequestBody CategoriaReceived categoriaReceived) {
        CategoriaResponse categoriaResponse = categoriaController.updateCategoria(categoriaReceived);
        return ResponseEntity.ok(categoriaResponse);
    }

    @PostMapping
    @Transactional
//    @Tag(name = "Categoria")
//    @Operation(summary = "Cadastrar categoria")
    public ResponseEntity<CategoriaResponse> cadatrarCategoria(@Valid @RequestBody CategoriaReceived categoriaReceived) {
        CategoriaResponse categoriaResponse = categoriaController.saveCategoria(categoriaReceived);
        return ResponseEntity.ok(categoriaResponse);
    }


    @PutMapping("/inativar/{id}")
    @Transactional
//    @Tag(name = "Categoria")
//    @Operation(summary = "Ativar / Inativar categoria")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void inativarCategoria(@PathVariable Long id) {
        categoriaController.deleteCategoria(id);
    }

}
