package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.modelo.Educacion;
import java.util.List;

/**
 *
 * @author piotr
 */
public interface IEducacionService {
    public List<Educacion> getEducaciones();
    public String crearEducacion(Educacion educacion);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
    public void modificarEducacion(Long id,Educacion edu);
}
