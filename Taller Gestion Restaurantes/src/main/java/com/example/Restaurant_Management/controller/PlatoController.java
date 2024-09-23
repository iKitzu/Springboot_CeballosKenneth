package com.example.Restaurant_Management.controller;


import com.example.Restaurant_Management.model.PlatoModel;
import com.example.Restaurant_Management.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ratatouille/Platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;


    //localhost:8080/Ratatouille/Platos

    @GetMapping
    public List<PlatoModel> getAllPlatos(){

        return platoService.getAllPlatos();

    }

    //localhost:880/Ratatouille/Platos/{id} <-- xd
    @GetMapping("/{id}")
    public PlatoModel getPlatoByID(@PathVariable Long id){

        return platoService.getPlatoByID(id).orElseThrow();

    }

    // Crear plato
    //localhost:8080/Ratatouille/Plato con verbo POST
    //{
    //  "nombre":"ceviche",
    //  "precio":2500
    //  "disponibilidad":"true"
    //  }

    @PostMapping
    public PlatoModel createPlato(@RequestBody PlatoModel platoModel){

        return platoService.savePlato(platoModel);

    }

    @PutMapping("/{id}")
    public PlatoModel updatePlato(@PathVariable Long id, @RequestBody PlatoModel platoModel){
        return platoService.updatePlato(id, platoModel);
    }

    @DeleteMapping("/{id}")
    public void deletePlatoByid(@PathVariable Long id){

        platoService.deletePlato(id);

    }

}
