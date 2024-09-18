package com.dia2.Inyeccion.services;

import com.dia2.Inyeccion.model.Productos;
import com.dia2.Inyeccion.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {
    @Autowired

    private ProductosRepository productosRepository;

    public List<Productos> buscarProductos(){
        return productosRepository.findAll();
    }

    public Productos guardarProducto(Productos productos) {
        return productosRepository.save(productos);
    }

    public Productos buscarPorID (int id){
        return productosRepository.findById(id).orElse(null);
    }

    public void borrarProducto (int id){
        productosRepository.deleteById(id);
    }
}
