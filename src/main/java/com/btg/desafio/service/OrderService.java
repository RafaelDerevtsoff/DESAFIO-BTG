package com.btg.desafio.service;

import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;

import java.util.List;
import java.util.Map;

public interface OrderService {
    void saveOrder(Orders orders);
    Double getTotal(Long orderNumber);
    List<OrderByClient> getOrderByClient();
    Map<Long, List<Orders>> getClientsOrders();
}
