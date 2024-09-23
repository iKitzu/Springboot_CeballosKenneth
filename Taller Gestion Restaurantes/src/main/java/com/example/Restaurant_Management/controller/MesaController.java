package com.example.Restaurant_Management.controller;


import com.example.Restaurant_Management.model.MesaModel;
import com.example.Restaurant_Management.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ratatouille/Mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;


    //localhost:880/Ratatouille/Mesas

    @GetMapping
    public List<MesaModel> getAllMesas(){

        return mesaService.getAllMesas();

    }

    //localhost:8080/Ratatouille/Mesas/{id} <-- xd
    @GetMapping("/{id}")
    public MesaModel getMesaByID(@PathVariable Long id){

       return mesaService.getMesaByID(id).orElseThrow();

    }

    // Crear plato
    //localhost:8080/Ratatouille/Plato con verbo POST
    //{
    //  "nombre":"ceviche",
    //  "precio":2500
    //  "disponibilidad":"true"
    //  }

    @PostMapping
    public MesaModel createMesa (@RequestBody MesaModel mesaModel){

        return mesaService.saveMesa(mesaModel);

    }

    @PutMapping("/{id}")
    public MesaModel updateMesa(@PathVariable Long id, @RequestBody MesaModel mesaModel){
        return mesaService.updateMesa(id, mesaModel);
    }

    @DeleteMapping("/{id}")
    public void deleteMesaByID(@PathVariable Long id){

        mesaService.deleteMesa(id);

    }

}
