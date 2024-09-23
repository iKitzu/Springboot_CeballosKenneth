package com.example.Restaurant_Management.service;

import com.example.Restaurant_Management.model.MesaModel;
import com.example.Restaurant_Management.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<MesaModel> getAllMesas(){

        return mesaRepository.findAll();

    }

    public Optional<MesaModel> getMesaByID(Long id) {
        return mesaRepository.findById(id);
    }


    public MesaModel saveMesa(MesaModel mesaModel){

        return mesaRepository.save(mesaModel);

    }

    public void deleteMesa(Long id){

        mesaRepository.deleteById(id);

    }

    public MesaModel updateMesa(Long id, MesaModel mesaDetails){

        MesaModel mesaModel = mesaRepository.findById(id).orElseThrow();
        mesaModel.setNumero_mesa(mesaDetails.getNumero_mesa());
        mesaModel.setOcupada(mesaDetails.getOcupada());
        return mesaRepository.save(mesaModel);

    }

}
