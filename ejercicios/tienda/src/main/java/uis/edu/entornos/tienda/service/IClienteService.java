package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import uis.edu.entornos.tienda.model.Cliente;

public interface IClienteService {
    List<Cliente> getClientes();

    Cliente newCliente(Cliente cliente);

    Optional<Cliente> findClienteById(Long id);

    void deleteCliente(Long id);
}
