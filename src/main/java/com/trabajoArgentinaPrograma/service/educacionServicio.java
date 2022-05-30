package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Educacion;
import com.trabajoArgentinaPrograma.repositorio.educacionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author piotr
 */
@Service
public class educacionServicio implements IEducacionService {

    @Autowired
    educacionRepositorio repoEducacion;

    @Override
    public List<Educacion> getEducaciones() throws notFoundException{
        try{
        return repoEducacion.findAll();
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener todas las educaciones.");
        }
    }

    @Override
    public String crearEducacion(Educacion educacion) {
    
        repoEducacion.save(educacion);
        return "creado";
    }

    @Override
    public void borrarEducacion(Long id) throws notFoundException{
        try{
            repoEducacion.deleteById(id);
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar la educacion.");
        }
    }

    @Override
    public Educacion buscarEducacion(Long id) throws notFoundException{
        try{
            return repoEducacion.findById(id).orElse(null);
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener  la educacion.");
        }
    }
    
    

    @Override
    public void modificarEducacion(Long id, Educacion edu) throws notFoundException{
        try{
            Educacion educacionEncontrado = repoEducacion.findById(id).orElse(null);
        if (educacionEncontrado != null) {
            educacionEncontrado.setInstituto(edu.getInstituto());
            educacionEncontrado.setUbicacion(edu.getUbicacion());
            
            educacionEncontrado.setTitulo(edu.getTitulo());
            educacionEncontrado.setFechaInicio(edu.getFechaInicio());
            educacionEncontrado.setFechaFin(edu.getFechaFin());
            educacionEncontrado.setDescripcion(edu.getDescripcion());
            System.out.println(edu.toString());
            repoEducacion.save(educacionEncontrado);
        } else {
            throw new notFoundException("Error no se encontro la educacion.");
        }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar la educacion.");
        }
    }

}
