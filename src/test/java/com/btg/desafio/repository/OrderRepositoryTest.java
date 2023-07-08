package com.btg.desafio.repository;

import com.btg.desafio.entities.Item;
import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    OrderRepository orderRepositoryTest;
    Orders orders =  new Orders(1L,2L, new LinkedList<>());
    @BeforeEach
    public  void setupDatabase(){
        LinkedList<Item> items = new LinkedList<>();
        items.add(new Item(1L,"LAPIS",10L,10.0));
        orders.setItems(items);
        orderRepositoryTest.save(orders);
    }

    @Test
    public void testOrderBYCustomer() {
        List<OrderByClient> orderByClient = orderRepositoryTest.orderBYCustomer();
        Assertions.assertEquals(2L,orderByClient.get(0).getClient());
    }

}
