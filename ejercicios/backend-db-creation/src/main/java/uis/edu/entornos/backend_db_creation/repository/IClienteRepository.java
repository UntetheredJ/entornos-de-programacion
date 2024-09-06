package uis.edu.entornos.backend_db_creation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.backend_db_creation.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
