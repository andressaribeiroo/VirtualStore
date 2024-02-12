package com.tech.backend.service;

import com.tech.backend.entity.Produto;
import com.tech.backend.entity.ProdutoImagens;
import com.tech.backend.repository.ProdutoImagensRepository;
import com.tech.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional(readOnly = true)
    public List<ProdutoImagens> findAll(){
        return produtoImagensRepository.findAll();
    }
    public ProdutoImagens insert(Long produto_id, MultipartFile file){
        Produto produto = produtoRepository.findById(produto_id).get();
        ProdutoImagens produtoImagens = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" +nomeImagem );
                Files.write(caminho, bytes);
                produtoImagens.setName(nomeImagem);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        produtoImagens.setDataCreate(new Date());
        produtoImagens.setProduto(produto);
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public  ProdutoImagens update(ProdutoImagens produtoImagens) {
        produtoImagens.setDataUpdate(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public void delete(Long id) {
        ProdutoImagens produtoImagens = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(produtoImagens);

    }
}