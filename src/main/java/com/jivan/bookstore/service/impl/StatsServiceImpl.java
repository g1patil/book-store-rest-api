package com.jivan.bookstore.service.impl;

import com.jivan.bookstore.model.OrderView;
import com.jivan.bookstore.repository.StatsRepository;
import com.jivan.bookstore.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @author g1patil
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    StatsRepository statsRepository;


    @Override
    public List<OrderView> getMonthStats(Date fromDate, Date toDate) {
        return statsRepository.getMonthlyStats(fromDate,toDate);
    }
}
