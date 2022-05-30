package com.trabajoArgentinaPrograma.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author piotr
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class notFoundException extends RuntimeException{
    
    private static final long serialVersionID = 1L;

    public notFoundException(String mensaje) {
        super(mensaje);
    }
}
