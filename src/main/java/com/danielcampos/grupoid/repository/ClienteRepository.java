package com.danielcampos.grupoid.repository;

import com.danielcampos.grupoid.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
