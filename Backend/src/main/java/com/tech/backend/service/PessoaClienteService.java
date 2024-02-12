package com.tech.backend.service;

import com.tech.backend.dto.PessoaClienteDTO;
import com.tech.backend.entity.Pessoa;
import com.tech.backend.repository.PermissaoRepository;
import com.tech.backend.repository.PessoaClienteRepository;
import com.tech.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;


    public Pessoa insert(PessoaClienteDTO pessoaCliente){
        Pessoa pessoa = new PessoaClienteDTO().converter(pessoaCliente);
        pessoa.setDataCreate(new Date());
        Pessoa newPessoa = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPermissaoPessoaCliente(newPessoa);
        return newPessoa;
    }


}