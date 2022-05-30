package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.modelo.Educacion;
import com.trabajoArgentinaPrograma.modelo.Persona;
import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import com.trabajoArgentinaPrograma.modelo.Trabajo;
import com.trabajoArgentinaPrograma.modelo.Usuario;
import java.util.List;

/**
 *
 * @author piotr
 */
public interface IPersonaService {
    
    public void modificarPersona(Long id,Persona pers);
    public void updateEducacionByIdPersona( Long id_persona,Long id_educacion, Educacion edu); 
    public void updateUsuarioByIdPersona( Long id_persona,Long id_usuario, Usuario usu); 
    public void updateTrabajoByIdPersona( Long id_persona,Long id_trabajo, Trabajo trab); 
    public void updateProyectoByIdPersona( Long id_persona, Long id_proyecto,Proyecto proy); 
    public void updateTecnologiaByIdPersona( Long id_persona, Long id_tecnologia,Tecnologia tec); 
    
    public Persona buscarPersona(Long id);
    public List<Persona> getPersonas();
    public Usuario getUsuarioByIdPersona(Long id_persona);
    public List<Educacion> getAllEducacionByIdPersona(Long id_persona);
    public List<Trabajo> getAllTrabajosByIdPersona( Long id_persona);
    public List<Proyecto> getAllProyectosByIdPersona( Long id_persona); 
    public List<Tecnologia> getAllTecnologiasByIdPersona(Long id_persona); 
    
    public void crearPersona(Persona persona);
    public void addEducacion( Long id_persona, Educacion edu); 
    public void addTrabajo( Long id_persona, Trabajo trab); 
    public void addProyecto( Long id_persona, Proyecto proy); 
    public void addTecnologia( Long id_persona, Tecnologia tec); 
    
    public void borrarPersona(Long id);
    public String deleteEducacionFromPersona( Long id_persona, Long id_educacion);
    public String deleteTecnologiaFromPersona( Long id_persona, Long id_tecnologia);
    public String deleteTrabajoFromPersona( Long id_persona,  Long id_trabajo); 
    public String deleteProyectoFromPersona(Long id_persona, Long id_proyecto); 
}
