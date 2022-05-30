package com.trabajoArgentinaPrograma.controlador;

import com.trabajoArgentinaPrograma.modelo.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Educacion;
import com.trabajoArgentinaPrograma.modelo.Proyecto;
import com.trabajoArgentinaPrograma.modelo.Tecnologia;
import com.trabajoArgentinaPrograma.modelo.Trabajo;
import com.trabajoArgentinaPrograma.modelo.Usuario;
import com.trabajoArgentinaPrograma.service.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author piotr
 */
@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200/")

public class personaControlador {

    @Autowired
    private IPersonaService personaServi;

    //este metodo sirve para actualizar persona
    @PutMapping("/personas/actualizar/{id}")
    public ResponseEntity<String> actualizarPersona(@PathVariable Long id, @RequestBody Persona detallesPersona) {
        try {
            personaServi.modificarPersona(id, detallesPersona);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    @PutMapping("/personas/actualizarEducacion/{id_persona}/educacion/{id_educacion}")
    public ResponseEntity<String> actualizarEducacionByIdPersona(@PathVariable Long id_persona, @PathVariable Long id_educacion, @RequestBody Educacion detallesEducacion) {
        try {
            personaServi.updateEducacionByIdPersona(id_persona, id_educacion, detallesEducacion);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 400)\n");
        }
    }

    @PutMapping("/personas/actualizarTrabajo/{id_persona}/trabajo/{id_trabajo}")
    public ResponseEntity<String> actualizarTrabajoByIdPersona(@PathVariable Long id_persona, @PathVariable Long id_trabajo, @RequestBody Trabajo detallesTrabajo) {
        try {
            personaServi.updateTrabajoByIdPersona(id_persona, id_trabajo, detallesTrabajo);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    @PutMapping("/personas/actualizarTecnologia/{id_persona}/tecnologia/{id_tecnologia}")
    public ResponseEntity<String> actualizaTecnologiaByIdPersona(@PathVariable Long id_persona, @PathVariable Long id_tecnologia, @RequestBody Tecnologia detallesTecnologia) {
        try {
            personaServi.updateTecnologiaByIdPersona(id_persona, id_tecnologia, detallesTecnologia);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    @PutMapping("/personas/actualizarProyecto/{id_persona}/proyecto/{id_proyecto}")
    public ResponseEntity<String> actualizarProyectoByIdPersona(@PathVariable Long id_persona, @PathVariable Long id_proyecto, @RequestBody Proyecto detallesProyecto) {
        try {
            personaServi.updateProyectoByIdPersona(id_persona, id_proyecto, detallesProyecto);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    @PutMapping("/personas/actualizarUsuario/{id_persona}/usuario/{id_usuario}")
    public ResponseEntity<String> actualizarUsuarioByIdPersona(@PathVariable Long id_persona, @PathVariable Long id_usuario, @RequestBody Usuario detallesUsuario) {
        try {
            personaServi.updateUsuarioByIdPersona(id_persona, id_usuario, detallesUsuario);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //////////////////// listar //////////////////////////////////////
    //este metodo sirve para buscar una persona
    @GetMapping("/personas/getPersona/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        try {
            Persona persona = personaServi.buscarPersona(id);
            return ResponseEntity.ok(persona);
        } catch (notFoundException error) {
            return (ResponseEntity<Persona>) ResponseEntity.notFound();
        }
    }

    //get el usuario que tiene una persona
    @GetMapping("/personas/getUsuario/{id_persona}")
    public ResponseEntity<Usuario> obtenerUsuarioByIdPersona(@PathVariable(value = "id_persona") Long id_persona) {
        try {
            Usuario usuario = personaServi.getUsuarioByIdPersona(id_persona);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (notFoundException error) {
            return (ResponseEntity<Usuario>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    //get todas las educaciones que tiene una persona
    @GetMapping("/personas/getEducaciones/{id_persona}")
    public ResponseEntity<List<Educacion>> listarAllEducacionByIdPersona(@PathVariable(value = "id_persona") Long id_persona) {
        try {
            List<Educacion> educaciones = personaServi.getAllEducacionByIdPersona(id_persona);
            return new ResponseEntity<>(educaciones, HttpStatus.OK);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Educacion>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    //get todos los trabajos que tiene una persona
    @GetMapping("/personas/getTrabajos/{id_persona}")
    public ResponseEntity<List<Trabajo>> listarAllTrabajosByIdPersona(@PathVariable(value = "id_persona") Long id_persona) {
        try {
            List<Trabajo> trabajos = personaServi.getAllTrabajosByIdPersona(id_persona);
            return new ResponseEntity<>(trabajos, HttpStatus.OK);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Trabajo>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    //get todos los proyectos que tiene una persona
    @GetMapping("/persona/getProyectos/{id_persona}")
    public ResponseEntity<List<Proyecto>> listarAllProyectosByIdPersona(@PathVariable(value = "id_persona") Long id_persona) {
        try {
            List<Proyecto> proyectos = personaServi.getAllProyectosByIdPersona(id_persona);
            return new ResponseEntity<>(proyectos, HttpStatus.OK);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Proyecto>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    //get todas las tecnologias que tiene una persona
    @GetMapping("/persona/getTecnologias/{id_persona}")
    public ResponseEntity<List<Tecnologia>> listarAllTecnologiasByIdPersona(@PathVariable(value = "id_persona") Long id_persona) {
        try {
            List<Tecnologia> tecnologias = personaServi.getAllTecnologiasByIdPersona(id_persona);
            return new ResponseEntity<>(tecnologias, HttpStatus.OK);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Tecnologia>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    //get todas las personas
    @GetMapping("personas/getPersonas")
    public ResponseEntity<List<Persona>> listarPersonas() {
        try {
            List<Persona> personas = personaServi.getPersonas();
            return ResponseEntity.ok(personas);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Persona>>) ResponseEntity.notFound();
        }
    }

    //////////////////// agregar //////////////////////////////////////
    //este metodo sirve para guardar una persona
    @PostMapping("/personas/crear")
    public ResponseEntity<String> guardarPersona(@RequestBody Persona persona) {
        try {
            personaServi.crearPersona(persona);
            return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 400)\n");
        }
    }

    //agregar una educacion a una persona
    @PostMapping("/personas/agregarEducacion/{id_persona}")
    public ResponseEntity<String> addEducacionByIdPersona(@PathVariable(value = "id_persona") Long id_persona, @RequestBody Educacion eduRequest) {
        try {
            personaServi.addEducacion(id_persona, eduRequest);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be ADDED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //agregar un trabajo a una persona
    @PostMapping("/personas/agregarTrabajo/{id_persona}")
    public ResponseEntity<String> addTrabajoByIdPersona(@PathVariable(value = "id_persona") Long id_persona, @RequestBody Trabajo trabRequest) {

        try {
            personaServi.addTrabajo(id_persona, trabRequest);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be ADDED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }

    }

    //agregar un proyecto a una persona
    @PostMapping("/personas/agregarProyecto/{id_persona}")
    public ResponseEntity<String> addProyectoByIdPersona(@PathVariable(value = "id_persona") Long id_persona, @RequestBody Proyecto proyRequest) {
        try {
            personaServi.addProyecto(id_persona, proyRequest);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be ADDED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //agregar una tecnologia a una persona
    @PostMapping("/personas/agregarTecnologia/{id_persona}")
    public ResponseEntity<String> addTecnologiaByIdPersona(@PathVariable(value = "id_persona") Long id_persona, @RequestBody Tecnologia tecRequest) {
        try {
            personaServi.addTecnologia(id_persona, tecRequest);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be ADDED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //////////////////// borrar //////////////////////////////////////
    //este metodo sirve para eliminar una educacion de una persona
    @DeleteMapping("/personas/eliminarEducacion/{id_persona}/{id_educacion}")
    public ResponseEntity<String> eliminarEducacionFromPersona(@PathVariable(value = "id_persona") Long id_persona, @PathVariable(value = "id_educacion") Long id_educacion) {
        try {
            personaServi.deleteEducacionFromPersona(id_persona, id_educacion);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //este metodo sirve para eliminar un trabajo de una persona
    @DeleteMapping("/personas/eliminarTrabajo/{id_persona}/{id_trabajo}")
    public ResponseEntity<String> eliminarTrabajoFromPersona(@PathVariable(value = "id_persona") Long id_persona, @PathVariable(value = "id_trabajo") Long id_trabajo) {
        try {
            personaServi.deleteTrabajoFromPersona(id_persona, id_trabajo);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //este metodo sirve para eliminar un trabajo de una persona
    @DeleteMapping("/personas/eliminarTecnologia/{id_persona}/{id_tecnologia}")
    public ResponseEntity<String> eliminarTecnologiaFromPersona(@PathVariable(value = "id_persona") Long id_persona, @PathVariable(value = "id_tecnologia") Long id_tecnologia) {
        try {
            personaServi.deleteTecnologiaFromPersona(id_persona, id_tecnologia);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //este metodo sirve para eliminar un proyecto de una persona
    @DeleteMapping("/personas/eliminarProyecto/{id_persona}/{id_proyecto}")
    public ResponseEntity<String> eliminarProyectoFromPersona(@PathVariable(value = "id_persona") Long id_persona, @PathVariable(value = "id_proyecto") Long id_proyecto) {
        try {
            personaServi.deleteProyectoFromPersona(id_persona, id_proyecto);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //este metodo sirve para eliminar una persona
    @DeleteMapping("/personas/eliminarPersona/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Long id) {
        try {
            personaServi.borrarPersona(id);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

}
