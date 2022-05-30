package com.trabajoArgentinaPrograma.controlador;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Contacto;
import com.trabajoArgentinaPrograma.service.IContactoService;
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
public class contactoControlador {

    @Autowired
    private IContactoService contactoServi;

    //get todas los Contactos
    @GetMapping("/getContactos")
    public ResponseEntity<List<Contacto>> listarContactos() {
        try {
            List<Contacto> contactos = contactoServi.getContactos();
            return ResponseEntity.ok(contactos);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Contacto>>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para guardar un Contacto
    @PostMapping("/contactos")
    public ResponseEntity<String> guardarContacto(@RequestBody Contacto contacto) {
        try {
            contactoServi.crearContacto(contacto);
            return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para buscar un Contacto
    @GetMapping("/contactos/{id}")
    public ResponseEntity<Contacto> obtenerContactoPorId(@PathVariable Long id) {
        try {
            Contacto contacto = contactoServi.buscarContacto(id);
            return ResponseEntity.ok(contacto);
        } catch (notFoundException error) {
            return (ResponseEntity<Contacto>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para actualizar Contacto
    @PutMapping("/contacto/{id}")
    public ResponseEntity<String> actualizarContacto(@PathVariable Long id, @RequestBody Contacto detallesContacto) {
        try {
            contactoServi.modificarContacto(id, detallesContacto);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para eliminar un Contacto
    @DeleteMapping("/contacto/{id}")
    public ResponseEntity<String> eliminarContacto(@PathVariable Long id) {
        try {
            contactoServi.borrarContacto(id);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }
}
