package com.example.explicacionJPA.controller;

import com.example.explicacionJPA.model.Persona;
import com.example.explicacionJPA.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaServices personaServices;

    // Obtener a todas las personas por ID
    @GetMapping
    public List<Persona> obtenerPersonas() {
        return personaServices.obtenerPersonas();
    }

    // Obtener a una persona por ID
    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaServices.obtenerPersonaPorId(id).orElseThrow();
    }

    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaServices.guardarPersona(persona);

    }

    // Actualizar Persona
    @PutMapping("/{id}")
    public  Persona actualizarPersona(@PathVariable Long id,@RequestBody Persona persona) {
        return personaServices.actualizarPersona(id, persona);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaServices.eliminarPersona(id);
    }

}
