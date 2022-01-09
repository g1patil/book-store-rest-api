package com.jivan.bookstore.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author g1patil
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    String errorMessage;
}
