package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Trabajo;
import com.trabajoArgentinaPrograma.repositorio.trabajoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author piotr
 */
@Service
public class trabajoServicio implements ITrabajoService {

    @Autowired
    trabajoRepositorio repoTrabajo;

    @Override
    public List<Trabajo> getTrabajos() throws notFoundException {
        try {
            return repoTrabajo.findAll();
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener todos los trabajos.");
        }
    }

    @Override
    public void crearTrabajo(Trabajo trabajo) throws notFoundException {
        try {
            repoTrabajo.save(trabajo);
        } catch (notFoundException error) {
            throw new notFoundException("Error al crear el trabajo.");
        }
    }

    @Override
    public void borrarTrabajo(Long id) throws notFoundException {
        try {
            repoTrabajo.deleteById(id);
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar el trabajo.");
        }
    }

    @Override
    public Trabajo buscarTrabajo(Long id) throws notFoundException {
        try {
            return repoTrabajo.findById(id).orElse(null);
        } catch (notFoundException error) {
            throw new notFoundException("Error al buscar el trabajo.");
        }
    }

    @Override
    public void modificarTrabajo(Long id, Trabajo trab) throws notFoundException {
        try {
            Trabajo trabajoEncontrado = repoTrabajo.findById(id).orElse(null);
            if (trabajoEncontrado != null) {
                trabajoEncontrado.setNombre(trab.getNombre());
                trabajoEncontrado.setPuesto(trab.getPuesto());
                trabajoEncontrado.setTareas(trab.getTareas());
                trabajoEncontrado.setFechaFin(trab.getFechaFin());
                trabajoEncontrado.setFechaInicio(trab.getFechaInicio());
                trabajoEncontrado.setUbicacion(trab.getUbicacion());
                repoTrabajo.save(trabajoEncontrado);
            } else {
               throw new notFoundException("Error no se encontro el trabajo.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar el trabajo.");
        }
    }

}
