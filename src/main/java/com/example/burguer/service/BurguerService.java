// BurguerService.java
package com.example.burguer.service;

import com.example.burguer.model.Burguer;
import com.example.burguer.model.dto.BurguerDTO;
import com.example.burguer.repository.BurguerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurguerService {
    
    @Autowired
    private BurguerRepository repository;
    
    public List<Burguer> listarTodos() {
        return repository.findAll();
    }
    
    public Optional<Burguer> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public Burguer salvar(BurguerDTO dto) {
        Burguer burguer = new Burguer();
        burguer.setNome(dto.getNome());
        burguer.setDescricao(dto.getDescricao());
        return repository.save(burguer);
    }
    
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}