package com.tech.backend.service;

import com.tech.backend.entity.Pessoa;
import com.tech.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Transactional(readOnly = true)
    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }
    public Pessoa insert(Pessoa pessoa){
        pessoa.setDataCreate(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public  Pessoa update(Pessoa pessoa) {
        pessoa.setDataUpdate(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void delete(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}