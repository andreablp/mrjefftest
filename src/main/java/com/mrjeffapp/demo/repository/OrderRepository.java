package com.mrjeffapp.demo.repository;

import com.mrjeffapp.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
