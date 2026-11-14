package com.example.springloja.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único da categoria gerado pelo banco", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Data da compra", example = "DD/MM/AAAA")
    private LocalDate data;

    @NotNull
    @Schema(description = "Valor total da venda", example = "R$ 50.00")
    private Double valor;

    @NotNull
    @Schema(description = "Cliente que fez a compra da venda", example="João Vitor")
    @ManyToOne
    private Cliente cliente;

    @NotNull
    @Schema(description = "Vendedor que mediou a compra", example="Luís Persuasivo")
    @ManyToOne
    private Vendedor vendedor;

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
