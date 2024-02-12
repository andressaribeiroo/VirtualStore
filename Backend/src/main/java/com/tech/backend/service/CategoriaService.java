package com.tech.backend.service;

import com.tech.backend.entity.Categoria;
import com.tech.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Transactional(readOnly = true)
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    public Categoria insert(Categoria categoria){
        categoria.setDataCreate(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public  Categoria update(Categoria categoria) {
        categoria.setDataUpdate(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void delete(Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);

    }
}