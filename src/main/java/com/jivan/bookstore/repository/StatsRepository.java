package com.jivan.bookstore.repository;

import com.jivan.bookstore.model.Order;
import com.jivan.bookstore.model.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author g1patil
 */
public interface StatsRepository  {

//    @Query("select monthname(created_at) as created_month , COUNT(*) , sum(item_count), sum(amount) as totalSale from orders  \n" +
//            " where created_at > ?1 and created_at< ?2 group by  monthname(created_at)")
//    List<OrderView> getMonthlyStats(Date fromDate , Date toDate);
}
