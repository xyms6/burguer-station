package com.example.burguer.repository;

import com.example.burguer.model.Burguer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurguerRepository extends JpaRepository<Burguer, Long> {
}