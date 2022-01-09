package com.jivan.bookstore.repository;

import com.jivan.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author g1patil
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Override
    Optional<Order> findById(Long id);
    List<Order> findAll();
    List<Order> findAllByUserId(Long id);
    Order save(Order order);

}
