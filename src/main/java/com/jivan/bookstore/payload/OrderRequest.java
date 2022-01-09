package com.jivan.bookstore.payload;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author g1patil
 */
@Data
public class OrderRequest {
    private Long user_id;
    private List<BookOrder> orderList;
    private String name;
    private BigDecimal orderTotal;
}
