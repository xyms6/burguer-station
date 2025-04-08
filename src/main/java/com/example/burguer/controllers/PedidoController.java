// PedidoController.java
package com.example.burguer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.burguer.Enum.StatusPedidos;
import com.example.burguer.model.Pedidos;
import com.example.burguer.model.dto.PedidoDTO;
import com.example.burguer.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService service;
    
    @GetMapping
    public ResponseEntity<List<Pedidos>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Pedidos> criar(@RequestBody PedidoDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }
    
    @PatchMapping("/{id}/status")
    public ResponseEntity<Pedidos> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusPedidos status) {
        return ResponseEntity.ok(service.atualizarStatus(id, status));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}