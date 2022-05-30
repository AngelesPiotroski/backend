package com.trabajoArgentinaPrograma.repositorio;

import com.trabajoArgentinaPrograma.modelo.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author piotr
 */
@Repository
public interface educacionRepositorio extends JpaRepository<Educacion, Long>{
   
}
