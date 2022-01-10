package com.jivan.bookstore.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author g1patil
 */
//@Entity
public class OrderView {
    String createdMonth;
    int count;
    int totalOrders;
    int itemsSold;
    BigDecimal totalSale;

}


//    select monthname(created_at) as created_month , COUNT(*) as totalOrders , sum(item_count) as itemsSold, sum(amount) as totalSale from orders
//        group by  monthname(created_at);