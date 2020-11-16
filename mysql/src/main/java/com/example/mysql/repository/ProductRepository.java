package com.example.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
