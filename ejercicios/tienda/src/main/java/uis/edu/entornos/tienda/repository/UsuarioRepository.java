package uis.edu.entornos.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.tienda.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
