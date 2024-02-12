package com.tech.backend.service;

import com.tech.backend.entity.Produto;
import com.tech.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional(readOnly = true)
    public List<Produto> findAll(){
       return produtoRepository.findAll();
    }
    public Produto insert(Produto produto){
        produto.setDataCreate(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public  Produto update(Produto produto) {
        produto.setDataUpdate(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public void delete(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);

    }
}