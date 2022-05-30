package com.trabajoArgentinaPrograma.controlador;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import com.trabajoArgentinaPrograma.service.ITecnologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author piotr
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class tecnologiaControlador {

    @Autowired
    private ITecnologiaService tecnologiaServi;

    @GetMapping("/tecnologias")
    public ResponseEntity<List<Tecnologia>> listarTecnologias() {
        try {
            List<Tecnologia> tecnologias = tecnologiaServi.getTecnologias();
            return ResponseEntity.ok(tecnologias);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Tecnologia>>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para guardar la Tecnologia
    @PostMapping("/tecnologias")
    public ResponseEntity<String> guardarTecnologia(@RequestBody Tecnologia tecnologia) {
        try {
            tecnologiaServi.creaTecnologia(tecnologia);
            return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 400)\n");
        }
    }

    //este metodo sirve para buscar una Tecnologia
    @GetMapping("/tecnologias/{id}")
    public ResponseEntity<Tecnologia> obtenerTecnologiaPorId(@PathVariable Long id) {
        try {
            Tecnologia tecnologia = tecnologiaServi.buscarTecnologia(id);
            return ResponseEntity.ok(tecnologia);
        } catch (notFoundException error) {
            return (ResponseEntity<Tecnologia>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para actualizar Tecnologia
    @PutMapping("/tecnologia/{id}")
    public ResponseEntity<String> actualizarTecnologia(@PathVariable Long id, @RequestBody Tecnologia detallesTecnologia) {
        try {
            tecnologiaServi.modificarTecnologia(id, detallesTecnologia);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para eliminar una Tecnologia
    @DeleteMapping("/tecnologia/{id}")
    public ResponseEntity<String> eliminarTecnologia(@PathVariable Long id) {
        try {
            tecnologiaServi.borrarTecnologia(id);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

   

    
}
