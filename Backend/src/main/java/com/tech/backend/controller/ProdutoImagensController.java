package com.tech.backend.controller;

import com.tech.backend.entity.ProdutoImagens;
import com.tech.backend.service.ProdutoImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/")
    public List<ProdutoImagens> findAll(){
        return produtoImagensService.findAll();
    }

    @PostMapping("/")
    public ProdutoImagens insert(@RequestParam("produto_id") Long produto_id, @RequestParam("file")MultipartFile file){
        return produtoImagensService.insert(produto_id, file);
    }

    @PutMapping("/")
    public ProdutoImagens update(@RequestBody ProdutoImagens produtoImagens){
        return produtoImagensService.update(produtoImagens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoImagensService.delete(id);
        return ResponseEntity.noContent().build();
    }
}