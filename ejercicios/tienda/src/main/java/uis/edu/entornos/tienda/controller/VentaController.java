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
import uis.edu.entornos.tienda.model.Venta;
import uis.edu.entornos.tienda.service.VentaService;

@RestController
public class VentaController {
    @Autowired
    VentaService ventaService;

    /**
     * Se obtiene la lista de ventas
     * 
     * @return lista de ventas
     */
    @Operation(summary = "Obtiene todas las ventas")
    @GetMapping("/list/ventas")
    public List<Venta> getVentas() {
        return ventaService.getVentas();
    }

    /**
     * Se obtiene una venta por su id
     * 
     * @param id id de la venta
     * @return venta
     */
    @Operation(summary = "Obtiene una venta por su ID")
    @GetMapping("/list/ventas/{id}")
    public ResponseEntity<Venta> findById(@PathVariable Long id) {
        return ventaService.findVentaById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Se crea una nueva venta
     * 
     * @param venta venta a crear
     * @return venta creada
     */
    @Operation(summary = "Crea una venta")
    @PostMapping("/ventas")
    public Venta newVenta(@RequestBody Venta venta) {
        return ventaService.newVenta(venta);
    }

    /**
     * Se actualiza una venta
     * 
     * @param venta venta a actualizar
     * @return venta actualizada
     */
    @Operation(summary = "Actualiza una venta")
    @PutMapping("/ventas")
    public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta) {
        Optional<Venta> vent = ventaService.findVentaById(venta.getId());
        if(vent != null){
            return ResponseEntity.ok(ventaService.newVenta(venta));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Se elimina una venta
     * 
     * @param id id de la venta
     */
    @Operation(summary = "Elimina una venta")
    @DeleteMapping("/list/ventas/{id}")
    public ResponseEntity<Venta> deleteVenta(@PathVariable Long id) {
        Optional<Venta> venta = ventaService.findVentaById(id);
        if (venta != null) {
            ventaService.deleteVenta(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
