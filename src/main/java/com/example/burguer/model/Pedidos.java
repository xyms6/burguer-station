package com.example.burguer.model;

import com.example.burguer.Enum.StatusPedidos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double numeroPedido;
	
	@Enumerated(EnumType.STRING)
	private StatusPedidos status;
	
	public Pedidos() {
		this.status = StatusPedidos.RECEBIDO;
	}
	
	public Pedidos(Long id, Double numeroPedido) {
		this.id = id;
		this.numeroPedido = numeroPedido;
	}
	
	
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
