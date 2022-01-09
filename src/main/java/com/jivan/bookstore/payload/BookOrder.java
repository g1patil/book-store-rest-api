package com.jivan.bookstore.payload;

import lombok.Data;
import javax.validation.constraints.Min;


/**
 * @author g1patil
 */
@Data
public
class BookOrder {
    private Long id;
    @Min(1)
    private int quantity;
}
