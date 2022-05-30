package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.modelo.Contacto;
import java.util.List;

/**
 *
 * @author piotr
 */
public interface IContactoService {
    public List<Contacto> getContactos();
    public void crearContacto(Contacto cont);
    public void borrarContacto(Long id);
    public Contacto buscarContacto(Long id);
    public void modificarContacto(Long id,Contacto cont);
}
