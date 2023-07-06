package com.btg.desafio.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id
    private Long codigoCliente;
    @OneToMany(targetEntity = Orders.class,cascade = CascadeType.ALL)
    @JoinColumn(name= "client_fk",referencedColumnName = "codigoCliente")
    private List<Orders> pedidos;

    public Client() {
    }
    public Client(Long codigoCliente, List<Orders> pedidos) {
        this.codigoCliente = codigoCliente;
        this.pedidos = pedidos;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public List<Orders> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Orders> pedidos) {
        this.pedidos = pedidos;
    }
}
