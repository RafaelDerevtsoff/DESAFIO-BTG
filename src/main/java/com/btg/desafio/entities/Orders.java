package com.btg.desafio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.List;

@Entity
public class Orders {
    @Id
    private Long codigoPedido;
    private Long codigoCliente;
    @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
    @JoinColumn(name= "order_fk",referencedColumnName = "codigoPedido")
    @JsonProperty("itens")
    private List<Item> items;


    public Orders() {
    }

    public Orders(Long codigoPedido, Long codigoCliente,List<Item> items) {
        this.codigoPedido = codigoPedido;
        this.codigoCliente = codigoCliente;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return "Orders{" +
//                "id=" + id +
                ", codigoPedido=" + codigoPedido +
                ", codigoCliente=" + codigoCliente +
                ", items=" + items +
                '}';
    }
}
