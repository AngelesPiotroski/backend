package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.modelo.Usuario;
import java.util.List;

/**
 *
 * @author piotr
 */
public interface IUsuarioService {
    public List<Usuario> getUsuarios();
    public void crearUsuario(Usuario usuario);
    public void borrarUsuario(Long id);
    public Usuario buscarUsuario(Long id);
    public void modificarUsuario(Long id,Usuario usu);
    public Usuario iniciarSesion(Usuario usuario);
}
