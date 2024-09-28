package uis.edu.entornos.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import uis.edu.entornos.tienda.model.DetalleVenta;
import uis.edu.entornos.tienda.service.DetalleVentaService;

@RestController
public class DetalleVentaController {
    @Autowired
    DetalleVentaService detalleVentaService;

    /**
     * Se obtiene la lista de detalles de venta
     * 
     * @return lista de detalles de venta
     */
    @Operation(summary = "Obtiene todos los detalles de venta")
    @GetMapping("/list/detalleVentas")
    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentaService.getDetalleVentas();
    }

    /**
     * Se obtiene un detalle de venta por su id
     * 
     * @param id id del detalle de venta
     * @return detalle de venta
     */
    @Operation(summary = "Obtiene un detalle de venta por su ID")
    @GetMapping("/list/detalleVentas/{id}")
    public ResponseEntity<DetalleVenta> findById(@PathVariable Long id) {
        return detalleVentaService.findDetalleVentaById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Se crea un nuevo detalle de venta
     * 
     * @param detalleVenta detalle de venta a crear
     * @return detalle de venta creado
     */
    @Operation(summary = "Crea un detalle de venta")
    @PostMapping("/detalleVentas")
    public ResponseEntity<DetalleVenta> newDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return ResponseEntity.ok(detalleVentaService.newDetalleVenta(detalleVenta));
    }

    /**
     * Se actualiza un detalle de venta
     * 
     * @param detalleVenta detalle de venta a actualizar
     * @return detalle de venta actualizado
     */
    @Operation(summary = "Actualiza un detalle de venta")
    @PutMapping("/detalleVentas")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        Optional<DetalleVenta> detalleVent = detalleVentaService.findDetalleVentaById(detalleVenta.getId());
        if (detalleVent != null) {
            return ResponseEntity.ok(detalleVentaService.newDetalleVenta(detalleVenta));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Se elimina un detalle de venta
     * 
     * @param id id del detalle de venta a eliminar
     * @return detalle de venta eliminado
     */
    @Operation(summary = "Elimina un detalle de venta")
    @DeleteMapping("/detalleVentas/{id}")
    public ResponseEntity<DetalleVenta> deleteDetalleVenta(@PathVariable Long id) {
        Optional<DetalleVenta> detalleVenta = detalleVentaService.findDetalleVentaById(id);
        if (detalleVenta != null) {
            detalleVentaService.deleteDetalleVenta(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
