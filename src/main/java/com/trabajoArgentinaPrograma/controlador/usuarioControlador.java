package com.trabajoArgentinaPrograma.controlador;

import com.trabajoArgentinaPrograma.excepciones.notFoundException;
import com.trabajoArgentinaPrograma.modelo.Usuario;
import com.trabajoArgentinaPrograma.service.IUsuarioService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author piotr
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://frontendargentinaprograma.web.app")
public class usuarioControlador {

    @Autowired
    private IUsuarioService usuarioServi;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioServi.getUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (notFoundException error) {
            return (ResponseEntity<List<Usuario>>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para guardar el usuarios
    @PostMapping("/usuarios/crear")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioServi.crearUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para buscar un usuarios
    @GetMapping("/usuarios/buscar/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioServi.buscarUsuario(id);
            return ResponseEntity.ok(usuario);
        } catch (notFoundException error) {
            return (ResponseEntity<Usuario>) ResponseEntity.notFound();
        }
    }

    //este metodo sirve para actualizar usuario
    @PutMapping("/usuario/actualizar/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario) {
        try {
            usuarioServi.modificarUsuario(id, detallesUsuario);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be MODIFICATED (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }

    //este metodo sirve para eliminar un usuario
    @DeleteMapping("/usuario/eliminar/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioServi.borrarUsuario(id);
            return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be Delete (CODE 201)\n");
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 201)\n");
        }
    }
    
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        try {
            Usuario usu = usuarioServi.iniciarSesion(usuario);
            if(usu!= null){
                return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will FINDED (CODE 201)\n");
            }else{
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("HTTP Status will not FINDED (CODE 201)\n");
            }
        } catch (notFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage() + " (CODE 400)\n");
            
        }
    }

}
