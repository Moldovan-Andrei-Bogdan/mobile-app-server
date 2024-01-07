package com.mecorp.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

public class ControllerAdvice {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<HttpErrorModel> handleException(Exception exception) {
        HttpErrorModel httpErrorModel = new HttpErrorModel();
        httpErrorModel.setMessage(exception.getMessage());
        httpErrorModel.setStatusCode(HttpStatus.NOT_FOUND);
        httpErrorModel.setTimestamp(LocalDate.now().toString());

        return new ResponseEntity<>(httpErrorModel, HttpStatus.NOT_FOUND);
    }
}
