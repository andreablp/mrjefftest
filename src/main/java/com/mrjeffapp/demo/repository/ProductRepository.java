package com.mrjeffapp.demo.repository;

import com.mrjeffapp.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
