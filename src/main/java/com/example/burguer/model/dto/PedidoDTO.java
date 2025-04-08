
package com.example.burguer.model.dto;

import com.example.burguer.Enum.StatusPedidos;

import jakarta.validation.constraints.NotNull;

public class PedidoDTO {
    private Long id;
    
    @NotNull(message = "O número do pedido é obrigatório")
    private Double numeroPedido;
    
    private StatusPedidos status;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Double numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public StatusPedidos getStatus() {
        return status;
    }

    public void setStatus(StatusPedidos status) {
        this.status = status;
    }
    
}