package com.abcproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.abcproject.dtos.ErrorResponse;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> noEncontrado(RuntimeException ex) {
        ErrorResponse respuesta = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    // @ExceptionHandler(DataIntegrityViolationException.class)
    // public ResponseEntity<ErrorResponse> registroDuplicado(DataIntegrityViolationException ex) {
    //     ErrorResponse respuesta = new ErrorResponse("Ya existe un empleado con este correo, favor de validar.", HttpStatus.BAD_REQUEST.value());
    //     return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    // }
}
