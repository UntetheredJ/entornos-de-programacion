package uis.edu.entornos.backend_db_creation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import uis.edu.entornos.backend_db_creation.model.Cliente;
import uis.edu.entornos.backend_db_creation.service.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Obtiene todos los clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }
    
    @Operation(summary = "Obtiene un cliente por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer idCliente) {
        return clienteService.findById(idCliente)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea un cliente")
    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }
    
    @Operation(summary = "Actualiza un cliente")
    @PutMapping
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente) {
        return clienteService.findById(cliente.getIdCliente())
                .map(c -> ResponseEntity.ok(clienteService.update(cliente)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    @Operation(summary = "Elimina un cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(Integer idCliente){
        return clienteService.findById(idCliente)
                .map(c -> {
                    clienteService.delete(idCliente);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
