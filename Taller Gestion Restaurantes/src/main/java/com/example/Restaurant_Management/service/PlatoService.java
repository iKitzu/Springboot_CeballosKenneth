package com.example.Restaurant_Management.service;

import com.example.Restaurant_Management.model.MesaModel;
import com.example.Restaurant_Management.model.PlatoModel;
import com.example.Restaurant_Management.repository.MesaRepository;
import com.example.Restaurant_Management.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public List<PlatoModel> getAllPlatos(){

        return platoRepository.findAll();

    }

    public Optional<PlatoModel> getPlatoByID(Long id){

        return platoRepository.findById(id);

    }

    public PlatoModel savePlato(PlatoModel platoModel){

        return platoRepository.save(platoModel);

    }

    public void deletePlato(Long id){

        platoRepository.deleteById(id);

    }

    public PlatoModel updatePlato(Long id, PlatoModel platoDetails){

        PlatoModel platoModel = platoRepository.findById(id).orElseThrow();
        platoModel.setNombre(platoDetails.getNombre());
        platoModel.setPrecio(platoDetails.getPrecio());
        platoModel.setDisponibilidad(platoDetails.getDisponibilidad());
        return platoRepository.save(platoModel);

    }


}
