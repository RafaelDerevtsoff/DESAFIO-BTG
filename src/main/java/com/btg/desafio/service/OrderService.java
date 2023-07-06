package com.btg.desafio.service;

import com.btg.desafio.entities.Item;
import com.btg.desafio.entities.Orders;
import com.btg.desafio.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void saveOrder(){
        ArrayList<Item> l  =  new ArrayList<Item>();
        l.add(new Item(1L,"pincel",10L,20.20));
        orderRepository.save(new Orders(100L,100L,l));
    }

}
