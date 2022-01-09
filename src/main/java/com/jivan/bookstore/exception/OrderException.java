package com.jivan.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @author g1patil
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public OrderException(final String _error){
        super(_error);
    }
    public OrderException(final List _error){
        super(_error.toString());
    }
}