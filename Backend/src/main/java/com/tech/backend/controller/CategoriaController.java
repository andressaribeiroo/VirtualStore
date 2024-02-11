package com.tech.backend.controller;

import com.tech.backend.entity.Categoria;
import com.tech.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }

    @PostMapping("/")
    public Categoria insert(@RequestBody Categoria categoria){
        return categoriaService.insert(categoria);
    }

    @PutMapping("/")
    public Categoria update(@RequestBody Categoria categoria){
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}