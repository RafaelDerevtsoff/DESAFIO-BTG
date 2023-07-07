package com.btg.desafio.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderByClient {
    @JsonProperty(value = "client")
    Long client ;
    @JsonProperty(value = "total")
    Long total;

    public OrderByClient(Long client, Long total) {
        this.client = client;
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderByClient{" +
                "client=" + client +
                ", total=" + total +
                '}';
    }
}
