package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import java.util.List;

/**
 *
 * @author piotr
 */
public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public void crearProyecto(Proyecto proyecto);
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);
    public void modificarProyecto(Long id,Proyecto proy);
    
    public List<Tecnologia> getAllTecnologiasByIdProyecto(Long id_proyecto);
    public Proyecto addTecnologiaByIdProyecto(Long id_proyecto, Tecnologia tec);
    public void updateTecnologiaByIdProyecto(Long id_proyecto,Long id_tecnologia,  Tecnologia tec);
    public String deleteTecnologiaFromProyecto(Long id_proyecto, Long  id_tecnologia);
}
