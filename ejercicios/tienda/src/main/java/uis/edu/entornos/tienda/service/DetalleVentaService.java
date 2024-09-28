package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.tienda.model.DetalleVenta;
import uis.edu.entornos.tienda.repository.DetalleVentaRepository;

@Service
@Transactional
public class DetalleVentaService implements IDetalleVentaService {
    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta newDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public Optional<DetalleVenta> findDetalleVentaById(Long id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public void deleteDetalleVenta(Long id) {
        detalleVentaRepository.deleteById(id);
        return;
    }
}
