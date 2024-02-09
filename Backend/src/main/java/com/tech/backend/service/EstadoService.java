package com.tech.backend.service;

import com.tech.backend.entity.Estado;
import com.tech.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }
    public Estado insert(Estado estado){
        estado.setDataCreate(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public  Estado update(Estado estado) {
        estado.setDataUpdate(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void delete(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);

    }
}