package com.tech.backend.controller;

import com.tech.backend.entity.Marca;
import com.tech.backend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> findAll(){
        return marcaService.findAll();
    }

    @PostMapping("/")
    public Marca insert(@RequestBody Marca marca){
        return marcaService.insert(marca);
    }

    @PutMapping("/")
    public Marca update(@RequestBody Marca marca){
        return marcaService.update(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        marcaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}