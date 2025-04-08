package com.example.burguer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.burguer.model.Burguer;
import com.example.burguer.model.dto.BurguerDTO;
import com.example.burguer.service.BurguerService;

@RestController
@RequestMapping("/burguers")
public class BurguerController {
	
	@Autowired
    private BurguerService service;
    
    @GetMapping
    public ResponseEntity<List<Burguer>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Burguer> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Burguer> criar(@RequestBody BurguerDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}