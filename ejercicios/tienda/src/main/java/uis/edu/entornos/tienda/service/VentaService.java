package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.tienda.repository.VentaRepository;
import uis.edu.entornos.tienda.model.Venta;

@Service
@Transactional
public class VentaService implements IVentaService {
    @Autowired
    VentaRepository ventaRepository;

    @Override
    public List<uis.edu.entornos.tienda.model.Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta newVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> findVentaById(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
