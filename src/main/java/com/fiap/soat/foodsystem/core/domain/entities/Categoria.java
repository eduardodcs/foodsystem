package com.fiap.soat.foodsystem.core.domain.entities;

public class Categoria {
    private Long id;
    private String nome;
    private boolean statusAtivo;

    public Categoria(String nome) {
        this.nome = nome;
    }

    Categoria(Long id, String nome, boolean statusAtivo) {
        this.id = id;
        this.nome = nome;
        this.statusAtivo = statusAtivo;
    }

    public Categoria(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

}
