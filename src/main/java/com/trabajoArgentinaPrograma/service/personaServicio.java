package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Educacion;
import com.trabajoArgentinaPrograma.modelo.Persona;
import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import com.trabajoArgentinaPrograma.modelo.Trabajo;
import com.trabajoArgentinaPrograma.modelo.Usuario;
import com.trabajoArgentinaPrograma.repositorio.educacionRepositorio;
import com.trabajoArgentinaPrograma.repositorio.personaRepositorio;
import com.trabajoArgentinaPrograma.repositorio.proyectoRepositorio;
import com.trabajoArgentinaPrograma.repositorio.tecnologiaRepositorio;
import com.trabajoArgentinaPrograma.repositorio.trabajoRepositorio;
import com.trabajoArgentinaPrograma.repositorio.usuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author piotr
 */
@Service
public class personaServicio implements IPersonaService {
    
    @Autowired
    personaRepositorio repoPersona;
    
    @Autowired
    tecnologiaRepositorio repoTecnologia;
    
    @Autowired
    proyectoRepositorio repoProyecto;
    
    @Autowired
    educacionRepositorio repoEducacion;
    
    @Autowired
    usuarioRepositorio repoUsuario;
     
    @Autowired
    trabajoRepositorio repoTrabajo;
    
    @Override
    public List<Persona> getPersonas() {
        try {
            return repoPersona.findAll();
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener todas las personas");
        }
    }
    
    @Override
    public void crearPersona(Persona persona) throws notFoundException {
        try {
            
            repoPersona.save(persona);
        } catch (notFoundException error) {
            throw new notFoundException("Error al crear la persona.");
        }
    }
    
    @Override
    public void borrarPersona(Long id) throws notFoundException {
        try {
            Persona per = repoPersona.findById(id).orElseThrow(() -> new notFoundException("No existe la persona con el ID : " + id));
            repoPersona.deleteById(id);
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar la persona.");
        }
    }
    
    @Override
    public Persona buscarPersona(Long id) throws notFoundException {
        try {
            Persona per = repoPersona.findById(id).orElseThrow(() -> new notFoundException("No existe la persona con el ID : " + id));
            
            return per;
            
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener la persona con el id " + id);
        }
    }
    
    @Override
    public void modificarPersona(Long id, Persona pers) throws notFoundException {
        try {
            Persona personaEncontrado = repoPersona.findById(id).orElse(null);
            
            if (personaEncontrado != null) {
                personaEncontrado.setNombre(pers.getNombre());
                personaEncontrado.setApellido(pers.getApellido());
                personaEncontrado.setDni(pers.getDni());
                personaEncontrado.setDomicilio(pers.getDomicilio());
                personaEncontrado.setFechaNacimiento(pers.getFechaNacimiento());
                personaEncontrado.setAboutMe(pers.getAboutMe());
                personaEncontrado.setEmail(pers.getEmail());
                personaEncontrado.setLugarNacimiento(pers.getLugarNacimiento());
                personaEncontrado.setTelefono(pers.getTelefono());
                personaEncontrado.setFotoPerfil(pers.getFotoPerfil());
                personaEncontrado.setFotoPortada(pers.getFotoPortada());
                
                repoPersona.save(personaEncontrado);
            } else {
                throw new notFoundException("Error no se encontro la persona.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar la persona.");
        }
    }
    
    @Override
    public List<Educacion> getAllEducacionByIdPersona(Long id_persona) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {
                return per.getEducaciones();
            } else {
                throw new notFoundException("No se encontro a la persona.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener la educacion de la persona.");
        }
    }
    
    @Override
    public List<Trabajo> getAllTrabajosByIdPersona(Long id_persona) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {
                return per.getTrabajos();
            } else {
                throw new notFoundException("No se encontro a la persona.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener los trabajos de la persona.");
        }
    }
    
    @Override
    public List<Proyecto> getAllProyectosByIdPersona(Long id_persona) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {
                return per.getProyectos();
            } else {
                throw new notFoundException("No se encontro a la persona.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener los proyectos de una persona.");
        }
    }
    
    @Override
    public List<Tecnologia> getAllTecnologiasByIdPersona(Long id_persona) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {
                return per.getTecnologias();
            } else {
                throw new notFoundException("No se encontro a la persona.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener las tecnologias de una persona.");
        }
    }
    
    @Override
    public Usuario getUsuarioByIdPersona(Long id_persona) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {
                return per.getUsuario();
            } else {
                throw new notFoundException("No se encontro a la persona.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener el usuario de la persona.");
        }
    }
    
    @Override
    public void addEducacion(Long id_persona, Educacion edu) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {  
                per.getEducaciones().add(edu);
                repoPersona.save(per);
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al agregar la educacion a la persona.");
        }
    }
    
    @Override
    public void addTrabajo(Long id_persona, Trabajo trab) {
       try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {  
                per.getTrabajos().add(trab);
                repoPersona.save(per);
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al agregar el trabajo a la persona.");
        }
    }
    
    @Override
    public void addTecnologia(Long id_persona, Tecnologia tec) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {  
                per.getTecnologias().add(tec);
                repoPersona.save(per);
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al agregar la tecnologia a la persona.");
        }
    }
    
    @Override
    public void addProyecto(Long id_persona, Proyecto proy) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            if (per != null) {  
                per.getProyectos().add(proy);
                repoPersona.save(per);
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al agregar el proyecto a la persona.");
        }
    }
    
    @Override
    public String deleteEducacionFromPersona(Long id_persona, Long id_educacion) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            Educacion edu = repoEducacion.findById(id_educacion).orElse(null);
            if (per != null && edu != null) {
                if (per.getEducaciones().contains(edu)) {
                    per.getEducaciones().remove(edu);
                    repoPersona.save(per);
                    return ("Educacion borrada exitosamente.");
                } else {
                    return ("La persona no posee la educacion a borrar.");
                }
            } else {
                return ("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar la educacion de la persona.");
        }
    }
    
    @Override
    public String deleteTrabajoFromPersona(Long id_persona, Long id_trabajo) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            Trabajo trab = repoTrabajo.findById(id_trabajo).orElse(null);
            if (per != null && trab != null) {
                if (per.getTrabajos().contains(trab)) {
                    per.getTrabajos().remove(trab);
                    repoPersona.save(per);
                    return ("Trabajo borrado exitosamente.");
                } else {
                    return ("La persona no posee el trabajo a borrar.");
                }
            } else {
                return ("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar el trabajo.");
        }
    }
    
    @Override
    public String deleteProyectoFromPersona(Long id_persona, Long id_proyecto) {
        try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            Proyecto proy = repoProyecto.findById(id_proyecto).orElse(null);
            if (per != null && proy != null) {
                if (per.getProyectos().contains(proy)) {
                    per.getProyectos().remove(proy);
                    repoPersona.save(per);
                    return ("Proyecto borrado exitosamente.");
                } else {
                    return ("La persona no posee el proyecto a borrar.");
                }
            } else {
                return ("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar el proyecto de la persona.");
        }
    }
    
    @Override
    public String deleteTecnologiaFromPersona(Long id_persona, Long id_tecnologia) {
       try {
            Persona per = repoPersona.findById(id_persona).orElse(null);
            Tecnologia tec= repoTecnologia.findById(id_tecnologia).orElse(null);
            if (per != null && tec!=null) {  
                per.getTecnologias().remove(tec);
                repoPersona.save(per);
                return("Se borro la tecnologia");
            }else{
                return ("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al agregar el trabajo a la persona.");
        }
    }
    
    @Override
    public void updateEducacionByIdPersona(Long id_persona, Long id_educacion, Educacion edu) {
        try {
            Persona personaEncontrado = repoPersona.findById(id_persona).orElse(null);
            Educacion educacionEncontrado= repoEducacion.findById(id_educacion).orElse(null);
            
            if (personaEncontrado != null && educacionEncontrado != null) {
                for (Educacion educ : personaEncontrado.getEducaciones()) {
                    if (educ.getId_educacion().equals(educacionEncontrado.getId_educacion())) {
                        educ.setDescripcion(edu.getDescripcion());
                        educ.setFechaFin(edu.getFechaFin());
                        educ.setFechaInicio(edu.getFechaInicio());
                        educ.setInstituto(edu.getInstituto());
                        educ.setTitulo(edu.getTitulo());
                        educ.setUbicacion(edu.getUbicacion());
                        repoEducacion.save(educ);
                    }
                }
            } else {
                throw new notFoundException("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar la educacion de la persona.");
        }
    }
    
    @Override
    public void updateUsuarioByIdPersona(Long id_persona, Long id_usuario, Usuario usu) {
        try {
            Persona personaEncontrado = repoPersona.findById(id_persona).orElse(null);
             Usuario usuarioEncontrado= repoUsuario.findById(id_usuario).orElse(null);
            
            if (personaEncontrado != null && usuarioEncontrado != null) {
                
                personaEncontrado.getUsuario().setContrasena(usu.getContrasena());
                personaEncontrado.getUsuario().setEmail(usu.getEmail());
                repoPersona.save(personaEncontrado);
            } else {
                throw new notFoundException("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar el usaurio de la pesona.");
        }
    }
    
    @Override
    public void updateTrabajoByIdPersona(Long id_persona, Long id_trabajo, Trabajo trab) {
        try {
            Persona personaEncontrado = repoPersona.findById(id_persona).orElse(null);
            Trabajo trabajoEncontrado= repoTrabajo.findById(id_trabajo).orElse(null);
            
            if (personaEncontrado != null && trabajoEncontrado != null) {
                for (Trabajo tra : personaEncontrado.getTrabajos()) {
                    if (tra.getId_trabajo().equals(trabajoEncontrado.getId_trabajo())) {
                        tra.setFechaFin(trab.getFechaFin());
                        tra.setFechaInicio(trab.getFechaInicio());
                        tra.setNombre(trab.getNombre());
                        tra.setPuesto(trab.getPuesto());
                        tra.setUbicacion(trab.getUbicacion());
                        
                        repoTrabajo.save(tra);
                    }
                }
            } else {
                throw new notFoundException("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar el trabajo de la persona.");
        }
    }
    
    @Override
    public void updateProyectoByIdPersona(Long id_persona, Long id_proyecto, Proyecto proy) {
        try {
            Persona personaEncontrado = repoPersona.findById(id_persona).orElse(null);
            Proyecto proyectoEncontrado = repoProyecto.findById(id_proyecto).orElse(null);
            
            if (personaEncontrado != null && proyectoEncontrado != null) {
               
                for (Proyecto p : personaEncontrado.getProyectos()) {
                    if (p.getId_proyecto().equals(proyectoEncontrado.getId_proyecto())) {
                       p.setDescripcion(proy.getDescripcion());
                       p.setNombre(proy.getNombre());
                       p.setUrl(proy.getUrl());
                       p.setUrlImagen(proy.getUrlImagen());
                        
                       repoProyecto.save(p);
                    }
                }
            } else {
                throw new notFoundException("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar el proyecto de la persona.");
        }
    }
    
    @Override
    public void updateTecnologiaByIdPersona(Long id_persona, Long id_tecnologia, Tecnologia tec) {
        try {
            Persona personaEncontrado = repoPersona.findById(id_persona).orElse(null);
            Tecnologia tecnologiaEncontrado = repoTecnologia.findById(id_tecnologia).orElse(null);
            
            if (personaEncontrado != null && tecnologiaEncontrado != null) {
               
                for (Tecnologia te : personaEncontrado.getTecnologias()) {
                    if (te.getId_tecnologia().equals(tecnologiaEncontrado.getId_tecnologia())) {
                        te.setDescripcion(tec.getDescripcion());
                        te.setNombre(tec.getNombre());
                        te.setPorcentaje(tec.getPorcentaje());
                        
                        repoTecnologia.save(te);
                    }
                }
            } else {
                throw new notFoundException("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar la tecnologia de la persona.");
        }
    }
}
