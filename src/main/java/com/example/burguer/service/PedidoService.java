// PedidoService.java
package com.example.burguer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.burguer.Enum.StatusPedidos;
import com.example.burguer.model.Pedidos;
import com.example.burguer.model.dto.PedidoDTO;
import com.example.burguer.repository.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repository;
    
    public List<Pedidos> listarTodos() {
        return repository.findAll();
    }
    
    public Optional<Pedidos> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public Pedidos salvar(PedidoDTO dto) {
        Pedidos pedido = new Pedidos();
        pedido.setNumeroPedido(dto.getNumeroPedido());
        pedido.setStatus(StatusPedidos.RECEBIDO); // Status padrão
        return repository.save(pedido);
    }
    
    public Pedidos atualizarStatus(Long id, StatusPedidos status) {
        Pedidos pedido = repository.findById(id).orElseThrow();
        pedido.setStatus(status);
        return repository.save(pedido);
    }
    
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}