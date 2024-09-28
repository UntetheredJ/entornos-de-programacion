package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import uis.edu.entornos.tienda.model.Venta;

public interface IVentaService {
    List<Venta> getVentas();

    Venta newVenta(Venta venta);

    Optional<Venta> findVentaById(Long id);

    void deleteVenta(Long id);
}
