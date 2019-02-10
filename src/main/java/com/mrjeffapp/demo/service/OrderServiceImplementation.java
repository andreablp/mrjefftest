package com.mrjeffapp.demo.service;

import com.mrjeffapp.demo.entity.Order;
import com.mrjeffapp.demo.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public Double getPrice(Order order) {

        Double price = order.getProducts()
            .stream()
            .mapToDouble(p -> p.getPrice()).sum();

        if (couponRepository.findByCode(order.getCoupon().getCode()).isPresent()) {
            return price- order.getCoupon().getValue();
        }
        return price;
    }
}
