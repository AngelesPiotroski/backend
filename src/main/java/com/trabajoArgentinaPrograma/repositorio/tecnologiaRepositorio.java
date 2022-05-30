package com.trabajoArgentinaPrograma.repositorio;

import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author piotr
 */
@Repository
public interface tecnologiaRepositorio extends JpaRepository<Tecnologia, Long>{
    
}
