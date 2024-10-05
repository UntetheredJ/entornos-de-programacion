package uis.edu.entornos.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uis.edu.entornos.tienda.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT COUNT(*) FROM Usuario AS usr WHERE usr.nombreUsuario = :nombreUsuario AND usr.password = :password")
    Integer findByNombreUsuarioAndPassword(@Param("nombreUsuario") String nombreUsuario, @Param("password") String password);


    @Query("SELECT usr FROM Usuario AS usr WHERE usr.nombreUsuario = :nombreUsuario AND usr.password = :password")
    Usuario findByNameAndPassword(@Param("nombreUsuario") String nombreUsuario, @Param("password") String password);
}
