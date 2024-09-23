package uis.edu.entornos.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import uis.edu.entornos.tienda.model.Usuario;
import uis.edu.entornos.tienda.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    /**
     * Se obtiene la lista de usuarios
     * 
     * @return lista de usuarios
     */
    @Operation(summary = "Obtiene todos los usuarios")
    @GetMapping("/list")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    /**
     * Se obtiene un usuario por su id
     * 
     * @param id id del usuario
     * @return usuario
     */
    @Operation(summary = "Obtiene un usuario por su ID")
    @GetMapping("/list/{id}")
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id);
    }

    /**
     * Se crea un nuevo usuario
     * 
     * @param usuario usuario a crear
     * @return usuario creado
     */
    @Operation(summary = "Crea un usuario")
    @PostMapping("/")
    public ResponseEntity<Usuario> newUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.newUsuario(usuario));
    }

    /**
     * Actualiza un usuario
     * 
     * @param usuario usuario a actualizar
     * @return usuario actualizado
     */
    @Operation(summary = "Actualiza un usuario")
    @PutMapping("/")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.findUsuarioById(usuario.getId());
        if (user != null) {
            return ResponseEntity.ok(usuarioService.newUsuario(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un usuario
     * 
     * @param id id del usuario a eliminar
     * @return usuario eliminado
     */
    @Operation(summary = "Elimina un usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        Usuario user = usuarioService.findUsuarioById(id);
        if (user != null) {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}