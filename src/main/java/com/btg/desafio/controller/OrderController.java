package com.btg.desafio.controller;

import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;
import com.btg.desafio.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping(path = "/get-total-order")
    public ResponseEntity<Double> getTotal(@RequestHeader Long orderNumber){
        return ResponseEntity.ok(orderService.getTotal(orderNumber));
    }
    @GetMapping(path = "/order-by-customer" )
    public ResponseEntity<List<OrderByClient>> getOrderByCustomer(){
        return ResponseEntity.ok(orderService.getOrderByClient());
    }
    @GetMapping(path = "/get-clients-orders" )
    public ResponseEntity<Map<Long,List<Orders>>> getClientsOrders(){
        return ResponseEntity.ok(orderService.getClientsOrders());
    }
}
