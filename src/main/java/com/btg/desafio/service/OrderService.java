package com.btg.desafio.service;

import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;

import java.util.List;

public interface OrderService {
    void saveOrder(Orders orders);
    Double getTotal(Long orderNumber);
    List<OrderByClient> getOrderByClient();
}
