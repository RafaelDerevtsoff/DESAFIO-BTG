package com.btg.desafio.repository;

import com.btg.desafio.entities.OrderByClient;
import com.btg.desafio.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    @Query("SELECT new com.btg.desafio.entities.OrderByClient(o.codigoCliente, COUNT(o.codigoPedido)) "
            + "FROM Orders o GROUP BY o.codigoCliente")
    List<OrderByClient> orderBYCustomer();
}
