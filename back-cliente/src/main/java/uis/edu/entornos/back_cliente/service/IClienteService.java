package uis.edu.entornos.back_cliente.service;

import java.util.List;

import uis.edu.entornos.back_cliente.model.Cliente;

public interface IClienteService {
    // Get Clientes
    public List<Cliente> getClientes();

    // Get Cliente by ID
    public Cliente getCliente(Integer id);

    // Save Cliente
    public Cliente saveCliente(Cliente cliente);

    // Delete Cliente
    public void deleteCliente(Integer id);
}
