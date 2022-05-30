package com.trabajoArgentinaPrograma.controlador;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Educacion;
import com.trabajoArgentinaPrograma.service.IEducacionService;
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
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200/")
public class educacionControlador {

    @Autowired
    private IEducacionService educacionServ;

    @GetMapping("/educacion")
    public ResponseEntity<List<Educacion>> listarEducacion() {
        try {
            List<Educacion> educaciones = educacionServ.getEducaciones();
            return ResponseEntity.ok(educaciones);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Educacion>>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para guardar la Educacion
    @PostMapping("/educacion/guardar")
    public String guardarEducacion(@RequestBody Educacion educacion) {
        return educacionServ.crearEducacion(educacion);
    }

    //este metodo sirve para buscar una Educacion
    @GetMapping("/educacion/{id}")
    public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable Long id) {
        Educacion educacion = educacionServ.buscarEducacion(id);
        return ResponseEntity.ok(educacion);
    }

    //este metodo sirve para actualizar Educacion
    @PutMapping("/educacion/{id}")
    public ResponseEntity<String> actualizarEducacion(@PathVariable Long id, @RequestBody Educacion detallesEducacion) {
        try {
            educacionServ.modificarEducacion(id, detallesEducacion);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para eliminar una Educacion
    @DeleteMapping("/educacion/{id}")
    public ResponseEntity<String> eliminarEducacion(@PathVariable Long id) {
        try {
            educacionServ.borrarEducacion(id);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

}
