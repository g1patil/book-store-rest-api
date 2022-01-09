package com.jivan.bookstore.payload;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

/**
 * @author g1patil
 */
@Data
public class OrderResponse {
    String orderName;
    Long orderId;
    String invoiceId;
    Date createdAt;
}
