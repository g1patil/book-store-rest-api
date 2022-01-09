package com.jivan.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author g1patil
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {OrderException.class})
    protected ResponseEntity<ErrorResponse> handleInvalidDataException(
            RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse("Failed with Invalid data" + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
