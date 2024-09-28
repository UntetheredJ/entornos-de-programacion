package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.tienda.model.Proveedor;
import uis.edu.entornos.tienda.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorService implements IProveedorService {
    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor newProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Optional<Proveedor> findProveedorById(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
        return;
    }
}
