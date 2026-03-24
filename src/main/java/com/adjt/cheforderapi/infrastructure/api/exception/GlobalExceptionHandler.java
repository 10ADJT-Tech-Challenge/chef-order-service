package com.adjt.cheforderapi.infrastructure.api.exception;

import com.adjt.cheforderapi.core.exceptions.PedidoNaoEncontradoException;
import com.adjt.cheforderapi.core.exceptions.PedidoNaoPertenceAoUsuarioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PedidoNaoPertenceAoUsuarioException.class)
    public ResponseEntity<Object> handlePedidoNaoPertence(PedidoNaoPertenceAoUsuarioException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Map.of(
                        "erro", "FORBIDDEN",
                        "mensagem", ex.getMessage()
                ));
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ResponseEntity<Object> handleNotFound(PedidoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "erro", "NOT_FOUND",
                        "mensagem", ex.getMessage()
                ));
    }
}