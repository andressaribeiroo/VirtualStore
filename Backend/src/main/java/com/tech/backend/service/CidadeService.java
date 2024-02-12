package com.tech.backend.service;

import com.tech.backend.entity.Cidade;
import com.tech.backend.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;


    @Transactional(readOnly = true)
    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }
    public Cidade insert(Cidade cidade){
        cidade.setDataCreate(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public  Cidade update(Cidade cidade) {
        cidade.setDataUpdate(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public void delete(Long id) {
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);

    }
}