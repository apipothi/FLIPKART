package com.apipothi.flipkart.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apipothi.flipkart.model.FlipkartProduct;

public interface FlipkartDAO extends MongoRepository<FlipkartProduct, Integer> {

}
