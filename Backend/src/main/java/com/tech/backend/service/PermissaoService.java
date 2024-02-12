package com.tech.backend.service;

import com.tech.backend.entity.Permissao;
import com.tech.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;


    @Transactional(readOnly = true)
    public List<Permissao> findAll(){
        return permissaoRepository.findAll();
    }
    public Permissao insert(Permissao permissao){
        permissao.setDataCreate(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public  Permissao update(Permissao permissao) {
        permissao.setDataUpdate(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public void delete(Long id) {
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);

    }
}