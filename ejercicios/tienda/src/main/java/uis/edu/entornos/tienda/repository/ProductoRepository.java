package uis.edu.entornos.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uis.edu.entornos.tienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
