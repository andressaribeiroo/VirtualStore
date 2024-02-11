package com.tech.backend.controller;

import com.tech.backend.entity.Produto;
import com.tech.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @PostMapping("/")
    public Produto insert(@RequestBody Produto produto){
        return produtoService.insert(produto);
    }

    @PutMapping("/")
    public Produto update(@RequestBody Produto produto){
        return produtoService.update(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}