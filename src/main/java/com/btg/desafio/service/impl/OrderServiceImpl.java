package com.btg.desafio.service.impl;

import com.btg.desafio.entities.Item;
import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;
import com.btg.desafio.exception.NotFoundException;
import com.btg.desafio.repository.OrderRepository;
import com.btg.desafio.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Double getTotal(Long orderNumber) {
        String functionName = "GET-TOTAL";
        LOGGER.info("[START-{}]", functionName);
        final Optional<Orders> order = orderRepository.findById(orderNumber);
        if (order.isPresent()) {
            LOGGER.info("[END-{}]", functionName);
            return order.get().getItems().stream().mapToDouble(Item::getTotal).sum();
        }
        throw new NotFoundException("ORDER NOT FOUND");
    }

    @Override
    public List<OrderByClient> getOrderByClient() {
        String functionName = "GET-ORDER-BY-CLIENT";
        LOGGER.info("[START-{}]", functionName);
        List<OrderByClient> list = orderRepository.orderBYCustomer();
        LOGGER.info("[END-{}] :: order by client : {}", functionName, list);
        return list;
    }

    @Override
    public Map<Long, List<Orders>> getClientsOrders() {
        String functionName = "GET-CLIENTS-ORDERS";
        LOGGER.info("[START-{}]", functionName);
        List<Orders> orders = orderRepository.findAll();
        final Map<Long, List<Orders>> ordersByClients = orders.stream().collect(groupingBy(Orders::getCodigoCliente));
        LOGGER.info("[END-{}] :: order by client : {}", functionName, ordersByClients);
        return ordersByClients;
    }

}
