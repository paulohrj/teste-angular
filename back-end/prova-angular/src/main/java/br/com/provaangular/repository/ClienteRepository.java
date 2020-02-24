package br.com.provaangular.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.provaangular.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
