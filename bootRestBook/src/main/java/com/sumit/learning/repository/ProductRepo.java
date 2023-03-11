package com.sumit.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.learning.entities.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

}
