package com.jivan.bookstore.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * @author g1patil
 */
@Data
@AllArgsConstructor
public class OrderValidationResponse extends OrderResponse{
    List<String> validationMessages;
}
