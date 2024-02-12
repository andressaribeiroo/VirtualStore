package com.tech.backend.dto;

import com.tech.backend.entity.Cidade;
import com.tech.backend.entity.Pessoa;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PessoaClienteDTO {

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;

    public Pessoa converter(PessoaClienteDTO pessoaClienteDTO){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteDTO, pessoa);
        return pessoa;
    }
}
