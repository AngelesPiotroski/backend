package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Usuario;
import com.trabajoArgentinaPrograma.repositorio.usuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author piotr
 */
@Service
public class usuarioServicio implements IUsuarioService {

    @Autowired
    usuarioRepositorio repoUsuario;

    @Override
    public List<Usuario> getUsuarios() throws notFoundException {
        try {
            return repoUsuario.findAll();
        } catch (notFoundException error) {
            throw new notFoundException("Error al buscar todos los usuarios.");
        }
    }

    @Override
    public void crearUsuario(Usuario usuario) throws notFoundException {
        try {
            repoUsuario.save(usuario);
        } catch (notFoundException error) {
            throw new notFoundException("Error al crear el usuario.");
        }
    }

    @Override
    public void borrarUsuario(Long id) throws notFoundException {
        try {
            repoUsuario.deleteById(id);
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar el usuario.");
        }
    }

    @Override
    public Usuario buscarUsuario(Long id) throws notFoundException {
        try {
            return repoUsuario.findById(id).orElse(null);
        } catch (notFoundException error) {
            throw new notFoundException("Error al buscar el usuario.");
        }
    }

    @Override
    public void modificarUsuario(Long id, Usuario usu) throws notFoundException {
        try {
            Usuario usuarioEncontrado = repoUsuario.findById(id).orElse(null);
            if (usuarioEncontrado != null) {
                usuarioEncontrado.setEmail(usu.getEmail());
                usuarioEncontrado.setContrasena(usu.getContrasena());
                repoUsuario.save(usuarioEncontrado);
            } else {
                throw new notFoundException("Error no se encontro el usuario.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar el usuario.");
        }
    }

    @Override
    public Usuario iniciarSesion(Usuario usuario) {
        try {
            List<Usuario> usuarios = repoUsuario.findAll();
            for (Usuario usu : usuarios) {
                if (usu.getEmail().equals(usuario.getEmail()) && usu.getContrasena().equals(usuario.getContrasena())) {
                    return usu;
                }
            }
            return null;
        } catch (notFoundException error) {
        throw new notFoundException("Error no se encontro el usuario.");
        }
    }
}
