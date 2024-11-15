package uis.edu.entornos.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
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
import uis.edu.entornos.tienda.model.Cliente;
import uis.edu.entornos.tienda.service.ClienteService;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    /**
     * Se obtiene la lista de clientes
     * 
     * @return lista de clientes
     */
    @Operation(summary = "Obtiene todos los clientes")
    @GetMapping("/list/clientes")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    /**
     * Se obtiene un cliente por su id
     * 
     * @param id id del cliente
     * @return cliente
     */
    @Operation(summary = "Obtiene un cliente por su ID")
    @GetMapping("/list/clientes/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return clienteService.findClienteById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Se crea un nuevo cliente
     * 
     * @param cliente cliente a crear
     * @return cliente creado
     */
    @Operation(summary = "Crea un cliente")
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> newCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.newCliente(cliente));
    }

    /**
     * Se actualiza un cliente
     * @param cliente cliente a actualizar
     * @return cliente actualizado
     */
    @Operation(summary = "Actualiza un cliente")
    @PutMapping("/clientes")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
        Optional<Cliente> client = clienteService.findClienteById(cliente.getId());
        if(client != null){

            return ResponseEntity.ok(clienteService.newCliente(cliente));
            
            
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Se elimina un cliente
     * @param id id del cliente a eliminar
     * @return cliente eliminado
     */
    @Operation(summary = "Elimina un cliente")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.findClienteById(id);
        if(cliente != null){
            clienteService.deleteCliente(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
