package com.microservice.shopcartnew.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@RedisHash("cart")
public class CartNew {

    @Id
    private Integer id;
    private List<ItemNew> items;

    public CartNew() {
    }

    public CartNew(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemNew> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<ItemNew> items) {
        this.items = items;
    }
}