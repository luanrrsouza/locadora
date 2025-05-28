package com.locadora.exception;

import com.locadora.response.Response;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<?>> handleAllExceptions(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ex.getMessage() != null ? ex.getMessage() : "Erro inesperado";


        if (ex instanceof ResponseStatusException) {

            ResponseStatusException rsEx = (ResponseStatusException) ex;
            try {
                status = (HttpStatus) rsEx.getClass().getMethod("getStatusCode").invoke(rsEx);
            } catch (Exception e) {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            message = rsEx.getReason() != null ? rsEx.getReason() : message;
        } else {

            ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
            if (responseStatus != null) {
                status = responseStatus.value();
                if (!responseStatus.reason().isEmpty()) {
                    message = responseStatus.reason();
                }
            }
        }

        Response<?> response = new Response<>(status.value(), message, null);
        return ResponseEntity.status(status).body(response);
    }
}