package uis.edu.entornos.tienda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.tienda.model.LoginDto;
import uis.edu.entornos.tienda.model.Usuario;
import uis.edu.entornos.tienda.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario newUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return;
    }

    @Override
    public int login(LoginDto usuarioDto) {
        return usuarioRepository.findByNombreUsuarioAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
    }

    @Override
    public ResponseEntity<?> ingresar(LoginDto usuarioDto){
        Map<String, Object> response = new HashMap<>();
        Usuario usuario = null;

        try{
            usuario = usuarioRepository.findByNameAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());

            if(usuario == null){
                response.put("mensaje", "Usuario o contraseña incorrectos");
                response.put("Usuario", null);
                response.put("statusCode", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                response.put("mensaje", "Usuario encontrado");
                response.put("Usuario", usuario);
                response.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch(Exception e){
            response.put("mensaje", "Error al ingresar");
            response.put("Usuario", null);
            response.put("error", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
