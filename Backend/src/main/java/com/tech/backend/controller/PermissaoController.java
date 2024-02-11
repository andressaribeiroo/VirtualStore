package com.tech.backend.controller;

import com.tech.backend.entity.Permissao;
import com.tech.backend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> findAll(){
        return permissaoService.findAll();
    }

    @PostMapping("/")
    public Permissao insert(@RequestBody Permissao permissao){
        return permissaoService.insert(permissao);
    }

    @PutMapping("/")
    public Permissao update(@RequestBody Permissao permissao){
        return permissaoService.update(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        permissaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}