package com.mrjeffapp.demo.service;

import com.mrjeffapp.demo.entity.Coupon;
import com.mrjeffapp.demo.entity.Order;
import com.mrjeffapp.demo.entity.Product;
import com.mrjeffapp.demo.repository.CouponRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class OrderServiceUnitTest {

    @Mock
    private CouponRepository couponRepository;

    @InjectMocks
    private OrderServiceImplementation service;

    private Coupon coupon;

    private Order order;

    private String randomCouponCode = "59+-";

    @Before
    public void setUp() {
        coupon = new Coupon(1L, "", 5D);

        Product product1 = new Product(1L, 10D, "1");
        Product product2 = new Product(2L, 5D, "2");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        order = new Order(1L, products, coupon);
    }

    @Test
    public void getPriceWithCoupon() {
        given(couponRepository.findByCode(coupon.getCode()))
                .willReturn(Optional.of(coupon));

        assertThat(service.getPrice(order)).isEqualTo(10);

    }

    @Test
    public void getPriceWithoutValidCoupon() {
        given(couponRepository.findByCode(""))
                .willReturn(Optional.empty());

        assertThat(service.getPrice(order)).isEqualTo(15);

    }
}
