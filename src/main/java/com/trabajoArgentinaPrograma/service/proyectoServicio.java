package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import com.trabajoArgentinaPrograma.repositorio.proyectoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author piotr
 */
@Service
public class proyectoServicio implements IProyectoService {

    @Autowired
    proyectoRepositorio repoProyecto;

    ITecnologiaService tecnologiaServi;

    @Override
    public List<Proyecto> getProyectos() throws notFoundException {
        try {
            return repoProyecto.findAll();
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener todos los proyectos.");
        }
    }

    @Override
    public void crearProyecto(Proyecto proyecto) throws notFoundException {
        try {
            repoProyecto.save(proyecto);
        } catch (notFoundException error) {
            throw new notFoundException("Error al crear el proyecto.");
        }
    }

    @Override
    public void borrarProyecto(Long id) throws notFoundException {
        try {
            repoProyecto.deleteById(id);
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar el proyecto.");
        }
    }

    @Override
    public Proyecto buscarProyecto(Long id) throws notFoundException {
        try {
            return repoProyecto.findById(id).orElse(null);
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener el proyecto.");
        }
    }

    @Override
    public void modificarProyecto(Long id, Proyecto proy) throws notFoundException {
        try {
            Proyecto proyectoEncontrado = repoProyecto.findById(id).orElse(null);
            if (proyectoEncontrado != null) {
                proyectoEncontrado.setNombre(proy.getNombre());
                proyectoEncontrado.setUrl(proy.getUrl());
                proyectoEncontrado.setUrlImagen(proy.getUrlImagen());
                proyectoEncontrado.setDescripcion(proy.getDescripcion());
                repoProyecto.save(proyectoEncontrado);
            } else {
                throw new notFoundException("Error no se encontro el proyecto.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar el proyecto.");
        }
    }

    @Override
    public Proyecto addTecnologiaByIdProyecto(Long id_proyecto, Tecnologia tec) {
        try {
            Proyecto proy = repoProyecto.findById(id_proyecto).orElse(null);
            if (proy.getTecnologias().contains(tec)) {
                throw new notFoundException("El proyecto ya posee esa tecnologia.");
            } else {
                proy.getTecnologias().add(tec);
                repoProyecto.save(proy);
                return proy;
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al agregar la tecnologia al proyecto.");
        }
    }

    @Override
    public void updateTecnologiaByIdProyecto(Long id_proyecto, Long id_tecnologia, Tecnologia tec) {
        try {
            Tecnologia tecnologiaEncontrado = tecnologiaServi.buscarTecnologia(id_tecnologia);
            Proyecto proyectoEncontrado = repoProyecto.findById(id_proyecto).orElse(null);

            if (tecnologiaEncontrado != null && proyectoEncontrado != null) {
                tecnologiaServi.modificarTecnologia(id_tecnologia, tec);
                for (Tecnologia te : proyectoEncontrado.getTecnologias()) {
                    if (te.getId_tecnologia().equals(tecnologiaEncontrado.getId_tecnologia())) {
                        te = tecnologiaServi.buscarTecnologia(id_tecnologia);
                        repoProyecto.save(proyectoEncontrado);
                    }
                }
            } else {
                throw new notFoundException("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar la tecnologia del proyecto.");
        }
    }

    @Override
    public String deleteTecnologiaFromProyecto(Long id_proyecto, Long  id_tecnologia) {
        try {
            Tecnologia tec = tecnologiaServi.buscarTecnologia(id_tecnologia);
            Proyecto proye = repoProyecto.findById(id_proyecto).orElse(null);
            if (tec != null && proye != null) {
                if (proye.getTecnologias().contains(tec)) {
                    proye.getTecnologias().remove(tec);
                    repoProyecto.save(proye);
                    return ("Tecnologia borrado exitosamente.");
                } else {
                    return ("El proyecto no posee la tecnologia a borrar.");
                }
            } else {
                return ("No se encontraron los datos necesarios.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar la tecnologia del proyecto.");
        }
    }

    @Override
    public List<Tecnologia> getAllTecnologiasByIdProyecto(Long id_proyecto) {
        try {
            Proyecto proy = repoProyecto.findById(id_proyecto).orElse(null);
            if (proy != null) {
                return proy.getTecnologias();
            } else {
                throw new notFoundException("No se encontro el proyecto.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener las tecnologias del proyecto.");
        }
    }
}
