package com.btg.desafio.service;

import com.btg.desafio.entities.Item;
import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;
import com.btg.desafio.repository.OrderRepository;
import com.btg.desafio.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceTest {
    @InjectMocks
    OrderServiceImpl orderService;
    @Mock
    OrderRepository orderRepository;
    static LinkedList<Orders> orders = new LinkedList<>();
    static LinkedList<Item> list = new LinkedList<Item>();

    @BeforeAll
    public static void setupVariables() {
        final Item lapis = new Item(1L, "Lapis", 20L, 15.9);
        final Item faca = new Item(2L, "Faca", 20L, 20.0);
        list.add(lapis);
        list.add(faca);
        Orders order = new Orders(1L, 1001L, list);
        Orders order1 = new Orders(1L, 1001L, list);
        Orders order2 = new Orders(1L, 1002L, list);
        Orders order3 = new Orders(1L, 1002L, list);
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.forEach(o -> o.setItems(list));
    }

    @Test
    public void getClientsOrdersTest() {
        when(orderRepository.findAll()).thenReturn(orders);
        final Map<Long, List<Orders>> result = orderService.getClientsOrders();
        Assertions.assertTrue(result.containsKey(1001L));
        Assertions.assertTrue(result.containsKey(1002L));
    }

    @Test
    public void getOrderByClientTest() {
        OrderByClient orderByClient = new OrderByClient(1L, 2L);
        LinkedList<OrderByClient> orderByClients = new LinkedList<>();
        orderByClients.add(orderByClient);
        when(orderRepository.orderBYCustomer()).thenReturn(orderByClients);
        final List<OrderByClient> result = orderService.getOrderByClient();
        Assertions.assertEquals(result.get(0),orderByClient);
    }
}
