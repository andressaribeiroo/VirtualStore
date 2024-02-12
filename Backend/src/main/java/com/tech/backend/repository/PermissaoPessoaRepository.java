package com.tech.backend.repository;

import com.tech.backend.entity.PermissaoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa, Long> {
}
