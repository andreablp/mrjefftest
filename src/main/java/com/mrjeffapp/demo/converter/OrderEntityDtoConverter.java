package com.mrjeffapp.demo.converter;

import com.mrjeffapp.demo.dto.OrderDto;
import com.mrjeffapp.demo.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityDtoConverter extends BaseEntityDtoConverter<Order, OrderDto> {

    public OrderEntityDtoConverter() {
        super(Order.class, OrderDto.class);
    }
}
