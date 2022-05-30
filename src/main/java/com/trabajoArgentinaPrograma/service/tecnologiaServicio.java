package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import com.trabajoArgentinaPrograma.repositorio.tecnologiaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author piotr
 */
@Service
public class tecnologiaServicio implements ITecnologiaService {

    @Autowired
    tecnologiaRepositorio repoTecnologia;
  
    IProyectoService proyectoServi;

    @Override
    public List<Tecnologia> getTecnologias() throws notFoundException {
        try {
            return repoTecnologia.findAll();
        } catch (notFoundException error) {
            throw new notFoundException("Error al obtener las tecnologias.");
        }
    }

    @Override
    public void creaTecnologia(Tecnologia tecnologia) throws notFoundException {
        try {
            repoTecnologia.save(tecnologia);
        } catch (notFoundException error) {
            throw new notFoundException("Error guardar la tecnologia.");
        }
    }

    @Override
    public void borrarTecnologia(Long id) throws notFoundException {
        try {
            repoTecnologia.deleteById(id);
        } catch (notFoundException error) {
            throw new notFoundException("Error al borrar la tecnologia.");
        }
    }

    @Override
    public Tecnologia buscarTecnologia(Long id) throws notFoundException {
        try {
            return repoTecnologia.findById(id).orElse(null);
        } catch (notFoundException error) {
            throw new notFoundException("Error al buscar la tecnologia.");
        }
    }

    @Override
    public void modificarTecnologia(Long id, Tecnologia tec) throws notFoundException {
        try {
            Tecnologia tecnologiaEncontrado = repoTecnologia.findById(id).orElse(null);
            if (tecnologiaEncontrado != null) {
                tecnologiaEncontrado.setNombre(tec.getNombre());
                tecnologiaEncontrado.setDescripcion(tec.getDescripcion());
                 tecnologiaEncontrado.setPorcentaje(tec.getPorcentaje());
                repoTecnologia.save(tecnologiaEncontrado);
            } else {
                throw new notFoundException("Error no se encontro la tecnologia.");
            }
        } catch (notFoundException error) {
            throw new notFoundException("Error al modificar la tecnologia.");
        }
    }

    


}
