package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Contacto;
import com.trabajoArgentinaPrograma.repositorio.contactoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author piotr
 */
@Service
public class contactoServicio implements IContactoService{
    
    @Autowired
    contactoRepositorio repoContacto;

    @Override
    public List<Contacto> getContactos() throws notFoundException {
        try {
            return repoContacto.findAll();
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener todos los Contactos.");
        }
    }

    @Override
    public void crearContacto(Contacto contacto) throws notFoundException {
        try {
            repoContacto.save(contacto);
        } catch (notFoundException error) {
            throw new notFoundException("Error al crear el Contacto.");
        }
    }

    @Override
    public void borrarContacto(Long id) throws notFoundException {
        try {
            repoContacto.deleteById(id);
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar el Contacto.");
        }
    }

    @Override
    public Contacto buscarContacto(Long id) throws notFoundException {
        try {
            return repoContacto.findById(id).orElse(null);
        } catch (notFoundException error) {
            throw new notFoundException("Error al buscar el Contacto.");
        }
    }

    @Override
    public void modificarContacto(Long id, Contacto cont) throws notFoundException {
        try {
            Contacto contactoEncontrado = repoContacto.findById(id).orElse(null);
            if (contactoEncontrado != null) {
                contactoEncontrado.setNombre(cont.getNombre());
                contactoEncontrado.setUrl(cont.getUrl());
                repoContacto.save(contactoEncontrado);
            } else {
                throw new notFoundException("Error no se encontro el contacto.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar el contacto.");
        }
    }
}
