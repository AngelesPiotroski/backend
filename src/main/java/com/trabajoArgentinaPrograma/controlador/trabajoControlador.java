package com.trabajoArgentinaPrograma.controlador;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Trabajo;
import com.trabajoArgentinaPrograma.service.ITrabajoService;
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
//@CrossOrigin(origins = "http://localhost:4200/")
public class trabajoControlador {

    @Autowired
    private ITrabajoService trabajoServi;

    @GetMapping("/trabajos")
    public ResponseEntity<List<Trabajo>> listarTrabajos() {
        try {
            List<Trabajo> trabajos = trabajoServi.getTrabajos();
            return ResponseEntity.ok(trabajos);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Trabajo>>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para guardar el Trabajo
    @PostMapping("/trabajos")
    public ResponseEntity<String> guardarTrabajo(@RequestBody Trabajo trabajo) {
        try {
            trabajoServi.crearTrabajo(trabajo);
            return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para buscar un Trabajo
    @GetMapping("/trabajos/{id}")
    public ResponseEntity<Trabajo> obtenerTrabajoPorId(@PathVariable Long id) {
        try {
            Trabajo trabajo = trabajoServi.buscarTrabajo(id);
            return ResponseEntity.ok(trabajo);
        } catch (notFoundException error) {
            return (ResponseEntity<Trabajo>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para actualizar Trabajo
    @PutMapping("/trabajo/{id}")
    public ResponseEntity<String> actualizarTrabajo(@PathVariable Long id, @RequestBody Trabajo detallesTrabajo) {
        try {
            trabajoServi.modificarTrabajo(id, detallesTrabajo);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 400)\n");
        }
    }

    //este metodo sirve para eliminar un Trabajo
    @DeleteMapping("/trabajo/{id}")
    public ResponseEntity<String> eliminarTrabajo(@PathVariable Long id) {
        try {
            trabajoServi.borrarTrabajo(id);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 400)\n");
        }
    }
}
