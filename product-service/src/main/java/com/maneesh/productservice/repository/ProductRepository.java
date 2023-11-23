package com.maneesh.productservice.repository;

import com.maneesh.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {


}
