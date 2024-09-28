package uis.edu.entornos.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uis.edu.entornos.tienda.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
