package com.trabajoArgentinaPrograma.service;

import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import java.util.List;

/**
 *
 * @author piotr
 */
public interface ITecnologiaService {
    
    public List<Tecnologia> getTecnologias();
    public void creaTecnologia(Tecnologia tecnologia);
    public void borrarTecnologia(Long id);
    public Tecnologia buscarTecnologia(Long id);
    public void modificarTecnologia(Long id,Tecnologia tec);
}
