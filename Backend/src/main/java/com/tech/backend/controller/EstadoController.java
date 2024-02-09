package com.tech.backend.controller;

import com.tech.backend.entity.Estado;
import com.tech.backend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> findAll(){
        return estadoService.findAll();
    }

    @PostMapping("/")
    public Estado insert(@RequestBody Estado estado){
        return estadoService.insert(estado);
    }

    @PutMapping("/")
    public Estado update(@RequestBody Estado estado){
        return estadoService.update(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        estadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}