package com.example.explicacionJPA.services;

import com.example.explicacionJPA.model.Persona;
import com.example.explicacionJPA.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PersonaServices {

    @Autowired
    private PersonaRepository personaRepository;

    // Obtener todas las personas

    public List<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    // Obtener una persona por ID
    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    // Guardar una Persona
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    // Eliminar una Persona por ID
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    // Actualizar Persona por ID
    public Persona actualizarPersona(Long id, Persona personaDetalles) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setName(personaDetalles.getName());
        persona.setAge(personaDetalles.getAge());
        return personaRepository.save(persona);
    }


}
