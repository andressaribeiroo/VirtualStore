package com.tech.backend.service;

import com.tech.backend.entity.Permissao;
import com.tech.backend.entity.PermissaoPessoa;
import com.tech.backend.entity.Pessoa;
import com.tech.backend.repository.PermissaoPessoaRepository;
import com.tech.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPermissaoPessoaCliente(Pessoa pessoa){
        List<Permissao> listaPermissao = permissaoRepository.findByName("cliente");
        if(listaPermissao.size()>0){
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCreate(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }
}