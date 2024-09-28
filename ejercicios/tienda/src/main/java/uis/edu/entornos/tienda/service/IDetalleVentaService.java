package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import uis.edu.entornos.tienda.model.DetalleVenta;

public interface IDetalleVentaService {
    List<DetalleVenta> getDetalleVentas();

    DetalleVenta newDetalleVenta(DetalleVenta detalleVenta);

    Optional<DetalleVenta> findDetalleVentaById(Long id);

    void deleteDetalleVenta(Long id);
}
