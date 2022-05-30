package com.trabajoArgentinaPrograma.repositorio;

import com.trabajoArgentinaPrograma.modelo.Proyecto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author piotr
 */
@Repository
public interface proyectoRepositorio extends JpaRepository<Proyecto, Long>{
    
}
