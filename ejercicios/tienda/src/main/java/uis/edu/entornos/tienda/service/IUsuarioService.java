package uis.edu.entornos.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import uis.edu.entornos.tienda.model.LoginDto;
import uis.edu.entornos.tienda.model.Usuario;

public interface IUsuarioService {
    List<Usuario> getUsuarios();

    Usuario newUsuario(Usuario usuario);

    Optional<Usuario> findUsuarioById(Long id);

    void deleteUsuario(Long id);

    int login(LoginDto usuarioDto);

    ResponseEntity<?> ingresar(LoginDto usuarDto);
}
