package com.btg.desafio.controller;

import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public ResponseEntity<Double> getTotal(@RequestHeader Long orderNumber){
        return ResponseEntity.ok(orderService.getTotal(orderNumber));
    }
    @GetMapping(path = "/order-by-customer" )
    public ResponseEntity<List<OrderByClient>> getOrderByCustomer(){
        ResponseEntity<List<OrderByClient>> result  =  ResponseEntity.ok(orderService.getOrderByClient());
        LOGGER.info("This is the result {}",result);
        return result;
    }
}
