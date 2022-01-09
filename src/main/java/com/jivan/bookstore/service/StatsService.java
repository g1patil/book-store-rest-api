package com.jivan.bookstore.service;

import com.jivan.bookstore.model.OrderView;

import java.util.Date;
import java.util.List;

/**
 * @author g1patil
 */
public interface StatsService {
    List<OrderView> getMonthStats(Date fromDate, Date toDate);
}
