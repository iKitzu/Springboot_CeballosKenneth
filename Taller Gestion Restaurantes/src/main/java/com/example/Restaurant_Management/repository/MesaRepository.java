package com.example.Restaurant_Management.repository;

import com.example.Restaurant_Management.model.MesaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<MesaModel, Long> {
}
