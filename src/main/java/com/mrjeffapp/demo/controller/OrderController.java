package com.mrjeffapp.demo.controller;

import com.mrjeffapp.demo.converter.OrderEntityDtoConverter;
import com.mrjeffapp.demo.dto.OrderDto;
import com.mrjeffapp.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    public static final String BASE_PATH = "/orders";

    @Autowired
    private OrderEntityDtoConverter converter;

    @Autowired
    private OrderService service;

    @PostMapping(BASE_PATH)
    public Double getPrice(@RequestBody OrderDto order) {
        return service.getPrice(converter.convertToEntity(order));
    }
}
