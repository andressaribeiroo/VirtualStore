package com.tech.backend.controller;

import com.tech.backend.entity.Cidade;
import com.tech.backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> findAll(){
        return cidadeService.findAll();
    }

    @PostMapping("/")
    public Cidade insert(@RequestBody Cidade cidade){
        return cidadeService.insert(cidade);
    }

    @PutMapping("/")
    public Cidade update(@RequestBody Cidade cidade){
        return cidadeService.update(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}