package com.tech.backend.controller;

import com.tech.backend.dto.PessoaClienteDTO;
import com.tech.backend.entity.Pessoa;
import com.tech.backend.service.PessoaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaService;

    @PostMapping("/")
    public Pessoa insert(@RequestBody PessoaClienteDTO pessoaCliente){
        return pessoaService.insert(pessoaCliente);
    }
}