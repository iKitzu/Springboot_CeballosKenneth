package com.dia2.Inyeccion.controller;

import com.dia2.Inyeccion.model.Productos;
import com.dia2.Inyeccion.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Productos")
public class ProductController {
    @Autowired
    private ProductosService productosService;

    @GetMapping
    public List<Productos> obtenerProdctos(){
        return productosService.buscarProductos();
    }
}
