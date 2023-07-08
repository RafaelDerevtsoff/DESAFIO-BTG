package com.btg.desafio.controller;

import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;
import com.btg.desafio.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderControllerTest {
    @InjectMocks
    OrderController orderController;
    @Mock
    OrderServiceImpl orderService;

    @Test
    public void getClientsOrdersController() {
        final LinkedList<OrderByClient> orderByClients = new LinkedList<>();
        final OrderByClient orderByClient = new OrderByClient(1L, 1L);
        final OrderByClient orderByClient1 = new OrderByClient(2L, 2L);
        final OrderByClient orderByClient2 = new OrderByClient(3L, 2L);
        final OrderByClient orderByClient3 = new OrderByClient(4L, 4L);
        orderByClients.add(orderByClient);
        orderByClients.add(orderByClient1);
        orderByClients.add(orderByClient2);
        orderByClients.add(orderByClient3);
        when(orderService.getOrderByClient()).thenReturn(orderByClients);
        ResponseEntity<Map<Long, List<Orders>>> result = orderController.getClientsOrders();
        Assertions.assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
    }

    @Test
    public void getOrderByCustomerTest() {
        OrderByClient orderByClient = new OrderByClient(1L, 2L);
        LinkedList<OrderByClient> orderByClients = new LinkedList<>();
        orderByClients.add(orderByClient);
        when(orderService.getOrderByClient()).thenReturn(orderByClients);
        final ResponseEntity<List<OrderByClient>> result = orderController.getOrderByCustomer();
        Assertions.assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
    }

    @Test
    public void getTotalTest() {
        when(orderService.getTotal(any(Long.class))).thenReturn(20.0);
        final ResponseEntity<Double> result = orderController.getTotal(1L);
        Assertions.assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
    }


}
