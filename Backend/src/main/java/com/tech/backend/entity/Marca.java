package com.tech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "marca")
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUpdate;
}