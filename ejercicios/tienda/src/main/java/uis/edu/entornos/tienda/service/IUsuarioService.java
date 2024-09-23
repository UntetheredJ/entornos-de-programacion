package uis.edu.entornos.tienda.service;

import java.util.List;
import uis.edu.entornos.tienda.model.Usuario;

public interface IUsuarioService {
    List<Usuario> getUsuarios();

    Usuario newUsuario(Usuario usuario);

    Usuario findUsuarioById(Long id);

    int deleteUsuario(Long id);
}
