package com.microservice.shopcartnew.controller;


import com.microservice.shopcartnew.model.CartNew;
import com.microservice.shopcartnew.model.ItemNew;
import com.microservice.shopcartnew.repository.CartNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartNewController {

    @Autowired
    private CartNewRepository cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public CartNew addItem(@PathVariable("id") Integer id, @RequestBody ItemNew item) {
        Optional<CartNew> savedCart = cartRepository.findById(id);
        CartNew cart;
        if (savedCart.equals(Optional.empty())) {
            cart = new CartNew(id);
        }
        else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<CartNew> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }

}