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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import uis.edu.entornos.tienda.model.Proveedor;
import uis.edu.entornos.tienda.service.ProveedorService;

@RestController
public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;

    /**
     * Se obtiene la lista de proveedores
     * 
     * @return lista de proveedores
     */
    @Operation(summary = "Obtiene todos los proveedores")
    @GetMapping("/list/proveedores")
    public List<Proveedor> getProveedores() {
        return proveedorService.getProveedores();
    }
    
    /**
     * Se obtiene un proveedor por su id
     * 
     * @param id id del proveedor
     * @return proveedor
     */
    @Operation(summary = "Obtiene un proveedor por su ID")
    @GetMapping("/list/proveedores/{id}")
    public ResponseEntity<Proveedor> findById(@PathVariable Long id) {
        return proveedorService.findProveedorById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Se crea un nuevo proveedor
     * 
     * @param proveedor proveedor a crear
     * @return proveedor creado
     */
    @Operation(summary = "Crea un proveedor")
    @PostMapping("/proveedores")
    public Proveedor newProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.newProveedor(proveedor);
    }

    /**
     * Se actualiza un proveedor
     * 
     * @param proveedor proveedor a actualizar
     * @return proveedor actualizado
     */
    @Operation(summary = "Actualiza un proveedor")
    @PutMapping("/proveedores")
    public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor) {
        Optional<Proveedor> newProv = proveedorService.findProveedorById(proveedor.getId());
        if (newProv != null) {
            return ResponseEntity.ok(proveedorService.newProveedor(proveedor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Se elimina un proveedor
     * 
     * @param id id del proveedor
     */
    @Operation(summary = "Elimina un proveedor")
    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> deleteProveedor(@PathVariable Long id) {
        Optional<Proveedor> proveedor = proveedorService.findProveedorById(id);
        if (proveedor != null) {
            proveedorService.deleteProveedor(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
