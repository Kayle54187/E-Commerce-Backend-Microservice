package com.kvs.productservice.Repository;

import com.kvs.productservice.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
