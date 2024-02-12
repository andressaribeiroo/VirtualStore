package com.tech.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "permissao_pessoa")
@Data
public class PermissaoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "permissao_id")
    private Permissao permissao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUpdate;
}