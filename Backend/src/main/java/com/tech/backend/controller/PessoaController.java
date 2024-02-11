package com.tech.backend.controller;

import com.tech.backend.entity.Pessoa;
import com.tech.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> findAll(){
        return pessoaService.findAll();
    }

    @PostMapping("/")
    public Pessoa insert(@RequestBody Pessoa pessoa){
        return pessoaService.insert(pessoa);
    }

    @PutMapping("/")
    public Pessoa update(@RequestBody Pessoa pessoa){
        return pessoaService.update(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}