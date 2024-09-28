package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.tienda.model.Producto;
import uis.edu.entornos.tienda.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService implements IProductoService {
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto newProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> findProductoById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
        return;
    }
}
