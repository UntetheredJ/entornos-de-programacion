package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.tienda.model.Cliente;
import uis.edu.entornos.tienda.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService implements IClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente newCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> findClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return;
    }
}