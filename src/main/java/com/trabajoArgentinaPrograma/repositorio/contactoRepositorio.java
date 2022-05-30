package com.trabajoArgentinaPrograma.repositorio;

import com.trabajoArgentinaPrograma.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author piotr
 */
@Repository
public interface contactoRepositorio extends JpaRepository<Contacto, Long>{
    
}
