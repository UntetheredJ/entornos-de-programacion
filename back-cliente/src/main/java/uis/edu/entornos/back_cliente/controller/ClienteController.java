package uis.edu.entornos.back_cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uis.edu.entornos.back_cliente.model.Cliente;
import uis.edu.entornos.back_cliente.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    /**
     * Get all clientes
     * 
     * @return List of clientes
     */
    @GetMapping("/list")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    /**
     * Get a cliente by id
     * 
     * @param id
     * @return Cliente
     */
    @GetMapping("/list/{id}")
    public Cliente getCliente(@PathVariable Integer id) {
        return clienteService.getCliente(id);
    }

    /**
     * Add a new cliente
     * 
     * @param cliente
     * @return Cliente
     */
    @PostMapping("/add")
    public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
        Cliente obj = clienteService.saveCliente(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    /**
     * Edit a cliente
     * 
     * @param cliente
     * @return Cliente
     */
    @PutMapping("/edit")
    public ResponseEntity<Cliente> edit(@RequestBody Cliente cliente) {
        Cliente obj = clienteService.getCliente(cliente.getIdcliente());
        if (obj != null) {
            obj.setDocumento(cliente.getDocumento());
            obj.setTipdoc(cliente.getTipdoc());
            obj.setNombres(cliente.getNombres());
            obj.setApellidos(cliente.getApellidos());
            obj.setDireccion(cliente.getDireccion());
            obj.setEmail(cliente.getEmail());
            obj = clienteService.saveCliente(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    /**
     * Delete a cliente
     * 
     * @param id
     * @return Cliente
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
        Cliente obj = clienteService.getCliente(id);
        if (obj != null) {
            clienteService.deleteCliente(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
