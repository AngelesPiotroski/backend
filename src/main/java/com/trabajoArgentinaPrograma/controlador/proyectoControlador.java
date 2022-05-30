package com.trabajoArgentinaPrograma.controlador;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import com.trabajoArgentinaPrograma.service.IProyectoService;
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
public class proyectoControlador {

    @Autowired
    private IProyectoService proyectoServi;

    @GetMapping("/proyectos")
    public ResponseEntity<List<Proyecto>> listarProyecto() {
        try {
            List<Proyecto> proyectos = proyectoServi.getProyectos();
            return ResponseEntity.ok(proyectos);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Proyecto>>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para guardar el Proyecto
    @PostMapping("/proyectos")
    public ResponseEntity<String> guardarProyecto(@RequestBody Proyecto proyecto) {
        try {
            proyectoServi.crearProyecto(proyecto);
            return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para buscar un Proyecto
    @GetMapping("/proyectos/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        try {
            Proyecto proyecto = proyectoServi.buscarProyecto(id);
            return ResponseEntity.ok(proyecto);
        } catch (notFoundException error) {
            return (ResponseEntity<Proyecto>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para actualizar Proyecto
    @PutMapping("/proyecto/{id}")
    public ResponseEntity<String> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto detallesProyecto) {
        try {
            proyectoServi.modificarProyecto(id, detallesProyecto);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para eliminar un Proyecto
    @DeleteMapping("/proyecto/{id}")
    public ResponseEntity<String> eliminarProyecto(@PathVariable Long id) {
        try {
            proyectoServi.borrarProyecto(id);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }
    
    @GetMapping("/proyectos/{id_proyecto}/tecnologias")
    public ResponseEntity<List<Tecnologia>> listarAllTecnologiasByIdProyecto(@PathVariable(value = "id_proyecto") Long id_proyecto) {
        try {
            List<Tecnologia> tecnologias = proyectoServi.getAllTecnologiasByIdProyecto(id_proyecto);
            return new ResponseEntity<>(tecnologias, HttpStatus.OK);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Tecnologia>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/proyecto/{id_proyecto}/tecnologia")
    public ResponseEntity<Proyecto> agregarTecnologiaByIdProyecto(@PathVariable(value = "id_proyecto") Long id_proyecto, @RequestBody Tecnologia tecnRequest) {
        try {
            Proyecto pro = proyectoServi.addTecnologiaByIdProyecto(id_proyecto, tecnRequest);
            return new ResponseEntity<>(pro, HttpStatus.OK);
        } catch (notFoundException error) {
            return (ResponseEntity<Proyecto>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/proyecto/{id_proyecto}/tecnologia/{id_tecnologia}")
    public ResponseEntity<String> actualizarTecnologiaByIdProyecto(@PathVariable Long id_proyecto, @PathVariable Long id_tecnologia, @RequestBody Tecnologia detallesTecnologia) {
        try {
            proyectoServi.updateTecnologiaByIdProyecto(id_proyecto, id_tecnologia, detallesTecnologia);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }
    
    @DeleteMapping("/proyectos/{id_proyecto}/tecnologias/{id_tecnologia}")
    public ResponseEntity<String> eliminarTecnologiaFromProyecto(@PathVariable(value = "id_tecnologia") Long id_tecnologia, @PathVariable(value = "id_proyecto") Long id_proyecto) {
       try {
            proyectoServi.deleteTecnologiaFromProyecto(id_proyecto, id_tecnologia);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
