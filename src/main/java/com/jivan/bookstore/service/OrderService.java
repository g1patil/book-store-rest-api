package com.jivan.bookstore.service;

import com.jivan.bookstore.payload.BookOrder;
import com.jivan.bookstore.model.Order;
import com.jivan.bookstore.payload.BookRequest;
import com.jivan.bookstore.payload.OrderRequest;

import java.util.List;

/**
 * @author g1patil
 */
public interface OrderService {
    Order getOrder(Long id);
    void updateInventoryForOrder(List<BookOrder> orderList);
    Order createOrder(OrderRequest orderRequest);
    Order updateOrder(Long id , BookRequest bookRequest);
    List<Order> getAllOrders();
    List<Order> getAllOrdersForCustomer(Long id);
    List<String> validateOrder(List<BookOrder> orderList);
}
