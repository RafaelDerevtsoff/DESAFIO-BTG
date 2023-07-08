package com.btg.desafio.controller;

import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    OrderController orderController;
    @Mock
    OrderServiceImpl orderService;

    @Test
    public void OrderController(){
        final LinkedList<OrderByClient> orderByClients = new LinkedList<>();
        orderController.getClientsOrders();
    }

}
