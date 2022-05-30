package com.trabajoArgentinaPrograma.repositorio;

import com.trabajoArgentinaPrograma.modelo.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author piotr
 */
@Repository
public interface personaRepositorio extends JpaRepository<Persona, Long>{
   List<Persona> findByDni(Long dni);
   List<Persona> findByNombre(String nombre); 
}
