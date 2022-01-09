package com.jivan.bookstore.controller;

import com.jivan.bookstore.exception.OrderException;
import com.jivan.bookstore.model.Book;
import com.jivan.bookstore.model.Order;
import com.jivan.bookstore.payload.OrderRequest;
import com.jivan.bookstore.payload.OrderResponse;
import com.jivan.bookstore.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author g1patil
 */
@Data
@RestController
@RequestMapping(path = "api/v1/orders")
@ResponseBody
@Transactional
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getOrder(@PathVariable(name = "id") Long id) {
        Order order =  orderService.getOrder(id);
        return new ResponseEntity(order, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Order> getAllOrders(@RequestParam Map<String,String> requestParams) {
        List<Order> orders = null ;
        if (requestParams.containsKey("userId")){
            orders = orderService.getAllOrdersForCustomer( Long.parseLong(requestParams.get("userId")));
        } else orders = orderService.getAllOrders();

        return new ResponseEntity(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest orderPayload){
        System.out.println(orderPayload);
        List<String> validationMessage = orderService.validateOrder(orderPayload.getOrderList());
        if (!validationMessage.isEmpty()){
            throw new OrderException(validationMessage);
        }

        orderService.updateInventoryForOrder(orderPayload.getOrderList());
        Order order = orderService.createOrder(orderPayload);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getId());
        orderResponse.setOrderName(order.getName());
        orderResponse.setCreatedAt(order.getCreatedAt());
        orderResponse.setInvoiceId(UUID.randomUUID().toString());
        return new ResponseEntity<>(orderResponse , HttpStatus.CREATED);

    }
}
