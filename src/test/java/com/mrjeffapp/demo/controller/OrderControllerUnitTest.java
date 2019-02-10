package com.mrjeffapp.demo.controller;

import com.mrjeffapp.demo.converter.OrderEntityDtoConverter;
import com.mrjeffapp.demo.dto.CouponDto;
import com.mrjeffapp.demo.dto.OrderDto;
import com.mrjeffapp.demo.dto.ProductDto;
import com.mrjeffapp.demo.entity.Coupon;
import com.mrjeffapp.demo.entity.Order;
import com.mrjeffapp.demo.entity.Product;
import com.mrjeffapp.demo.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerUnitTest {

    @Mock
    private OrderEntityDtoConverter converter;

    @Mock
    private OrderService service;

    @InjectMocks
    private OrderController controller;

    private CouponDto couponDto;
    private OrderDto orderDto;

    private Coupon coupon;
    private Order order;
    @Before
    public void setUp() {
        couponDto = new CouponDto(1L, "1", 5D);

        ProductDto productDto1 = new ProductDto(1L, 10D, "1");
        ProductDto productDto2 = new ProductDto(2L, 5D, "2");

        List<ProductDto> productsDto = new ArrayList<>();
        productsDto.add(productDto1);
        productsDto.add(productDto2);

        orderDto = new OrderDto(productsDto, couponDto);

        coupon = new Coupon(1L, "1", 5D);

        Product product1 = new Product(1L, 10D, "1");
        Product product2 = new Product(2L, 5D, "2");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        order = new Order(1L, products, coupon);
    }

    @Test
    public void getPrice() {

        Mockito.when(service.getPrice(order)).thenReturn(5D);

        given(converter.convertToEntity(orderDto)).willReturn(order);

        assertThat(controller.getPrice(orderDto).equals(15));
    }
}
