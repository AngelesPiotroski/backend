package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.modelo.Trabajo;
import java.util.List;

/**
 *
 * @author piotr
 */
public interface ITrabajoService {
    public List<Trabajo> getTrabajos();
    public void crearTrabajo(Trabajo trabajo);
    public void borrarTrabajo(Long id);
    public Trabajo buscarTrabajo(Long id);
    public void modificarTrabajo(Long id,Trabajo trab);
}
