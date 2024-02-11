package com.tech.backend.service;

import com.tech.backend.entity.Marca;
import com.tech.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll(){
        return marcaRepository.findAll();
    }
    public Marca insert(Marca marca){
        marca.setDataCreate(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public Marca update(Marca marca) {
        marca.setDataUpdate(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void delete(Long id) {
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);

    }
}