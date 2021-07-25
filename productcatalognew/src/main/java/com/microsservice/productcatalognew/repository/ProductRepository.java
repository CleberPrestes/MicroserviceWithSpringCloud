package com.microsservice.productcatalognew.repository;

import com.microsservice.productcatalognew.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
