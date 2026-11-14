package com.example.springloja.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do cliente gerado pelo banco", example = "1")
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Schema(description = "Nome do cliente", example = "João Vitor")
    private String nome;

    @NotNull
    @Schema(description = "Renda média do Cliente", example="R$ 2145.00")
    private Double renda;

    public Cliente() {
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
