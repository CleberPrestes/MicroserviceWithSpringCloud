package com.microservice.shopcartnew.repository;

import com.microservice.shopcartnew.model.CartNew;
import org.springframework.data.repository.CrudRepository;

public interface CartNewRepository extends CrudRepository<CartNew, Integer> {

    CartNew findByCustomerId(Integer customerId);

}