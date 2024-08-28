package uis.edu.entornos.back_cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uis.edu.entornos.back_cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
