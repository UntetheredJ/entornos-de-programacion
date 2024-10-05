package uis.edu.entornos.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import uis.edu.entornos.tienda.model.LoginDto;
import uis.edu.entornos.tienda.model.Usuario;
import uis.edu.entornos.tienda.service.UsuarioService;

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
    @GetMapping("/list/usuarios")
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
    @GetMapping("/list/usuarios/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Se crea un nuevo usuario
     * 
     * @param usuario usuario a crear
     * @return usuario creado
     */
    @Operation(summary = "Crea un usuario")
    @PostMapping("/usuarios")
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
    @PutMapping("/usuarios")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> user = usuarioService.findUsuarioById(usuario.getId());
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
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> user = usuarioService.findUsuarioById(id);
        if (user != null) {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Ingresa un usuario
     * 
     * @param usuarioDto usuario a ingresar
     * @return usuario ingresado
     */
    @Operation(summary = "Ingresa un usuario")
    @PostMapping("/loginclient")
    public int login(@RequestBody LoginDto usuarioDto) {
        return usuarioService.login(usuarioDto);
    }

    /**
     * Ingresa un usuario
     * 
     * @param usuarioDto usuario a ingresar
     * @return usuario ingresado
     */
    @Operation(summary = "Ingresa un usuario")
    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody LoginDto usuarioDto) {
        return usuarioService.ingresar(usuarioDto);
    }
}