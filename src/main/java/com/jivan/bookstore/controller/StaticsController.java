package com.jivan.bookstore.controller;

import com.jivan.bookstore.model.OrderView;
import com.jivan.bookstore.service.OrderService;
import com.jivan.bookstore.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author g1patil
 */
public class StaticsController {

    @Autowired
    StatsService statsService;

    @GetMapping
    public ResponseEntity getMonthlyStats(@Valid @RequestParam Map<String,String> datesRange ) throws ParseException {
        List<OrderView> viewList = statsService.getMonthStats(
                new SimpleDateFormat("dd-MM-yyyy").parse(datesRange.get("fromDate")),
                new SimpleDateFormat("dd-MM-yyyy").parse(datesRange.get("toDate")));
        return new ResponseEntity(viewList , HttpStatus.OK);
    }
}
