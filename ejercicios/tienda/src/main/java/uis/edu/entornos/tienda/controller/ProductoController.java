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
import uis.edu.entornos.tienda.model.Producto;
import uis.edu.entornos.tienda.service.ProductoService;

@RestController
public class ProductoController {
    @Autowired
    ProductoService productoService;

    /**
     * Se obtiene la lista de productos
     * 
     * @return lista de productos
     */
    @Operation(summary = "Obtiene todos los productos")
    @GetMapping("/list/productos")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    /**
     * Se obtiene un producto por su id
     * 
     * @param id id del producto
     * @return producto
     */
    @Operation(summary = "Obtiene un producto por su ID")
    @GetMapping("/list/productos/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id) {
        return productoService.findProductoById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Se crea un nuevo producto
     * 
     * @param producto producto a crear
     * @return producto creado
     */
    @Operation(summary = "Se crea un nuevo producto")
    @PostMapping("/productos")
    public ResponseEntity<Producto> newProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.newProducto(producto));
    }

    /**
     * Se actualiza un producto
     * 
     * @param producto producto a actualizar
     * @return producto actualizado
     */
    @Operation(summary = "Se actualiza un producto")
    @PutMapping("/productos")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        Optional<Producto> product = productoService.findProductoById(producto.getId());
        if (product != null) {
            return ResponseEntity.ok(productoService.newProducto(producto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Se elimina un producto
     * 
     * @param id id del producto a eliminar
     * @return producto eliminado
     */
    @Operation(summary = "Se elimina un producto")
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findProductoById(id);
        if (producto != null) {
            productoService.deleteProducto(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
