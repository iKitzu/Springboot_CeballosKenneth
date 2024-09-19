package com.example.explicacionJPA.repository;

import com.example.explicacionJPA.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}

