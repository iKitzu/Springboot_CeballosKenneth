package com.dia2.Inyeccion.repository;

import com.dia2.Inyeccion.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductosRepository  extends JpaRepository<Productos, Integer>{
}
