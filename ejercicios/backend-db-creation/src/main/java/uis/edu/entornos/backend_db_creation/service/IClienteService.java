package uis.edu.entornos.backend_db_creation.service;

import java.util.List;
import java.util.Optional;

import uis.edu.entornos.backend_db_creation.model.Cliente;

public interface IClienteService {
    List<Cliente> findAll();

    Optional<Cliente> findById(Integer id);

    Cliente create(Cliente cliente);

    Cliente update(Cliente cliente);

    void delete(Integer id);
}
