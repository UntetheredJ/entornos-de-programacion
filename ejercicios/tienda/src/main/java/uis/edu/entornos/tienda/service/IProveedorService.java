package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import uis.edu.entornos.tienda.model.Proveedor;

public interface IProveedorService {
    List<Proveedor> getProveedores();

    Proveedor newProveedor(Proveedor proveedor);

    Optional<Proveedor> findProveedorById(Long id);

    void deleteProveedor(Long id);
}
