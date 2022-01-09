package com.jivan.bookstore.service.impl;

import com.jivan.bookstore.exception.OrderException;
import com.jivan.bookstore.model.Book;
import com.jivan.bookstore.payload.BookOrder;
import com.jivan.bookstore.model.Order;
import com.jivan.bookstore.payload.BookRequest;
import com.jivan.bookstore.payload.OrderRequest;
import com.jivan.bookstore.repository.BookRepository;
import com.jivan.bookstore.repository.OrderRepository;
import com.jivan.bookstore.service.BookService;
import com.jivan.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Override
    public Order getOrder(Long id) {
        Order order =  orderRepository.findById(id).orElseThrow(()->new OrderException("Order not found"));
        return order;
    }

    @Override
    @Transactional
    public void updateInventoryForOrder(List<BookOrder> orderList) {
        orderList.stream().forEach( order ->{
            Book book = bookService.getBook(order.getId());
            book.getBookInventory().setAvailableCount(book.getBookInventory().getAvailableCount() - order.getQuantity());
            bookRepository.save(book);
        });
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setUserId(orderRequest.getUser_id());
        order.setName(orderRequest.getName());
        order.setInvoiceId(123L);
        order.setOrderTotal(orderRequest.getOrderTotal());
        order.setItemCount(orderRequest.getOrderList().stream().mapToInt(o->o.getQuantity()).sum());
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, BookRequest bookRequest) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long id) {
        return orderRepository.findAllByUserId(id);
    }

    @Override
    public List<String> validateOrder(List<BookOrder> orderList) {

        List<String> errors = new ArrayList<>();
        orderList.stream().forEach( order -> {
            errors.addAll(bookService.validateBookInventory(order.getId(), order.getQuantity()));
        });

        validateQuantityAmount(errors,orderList);
        return errors;
    }

    private void validateQuantityAmount(List<String> errors,List<BookOrder> orderList) {
        orderList.stream().forEach(o->{
            if (o.getQuantity() < 1 ){
                errors.add("Invalid quantity in the order");
            }
        });
    }
}
