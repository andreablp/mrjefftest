package com.mrjeffapp.demo.rest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.mrjeffapp.demo.controller.OrderController;
import com.mrjeffapp.demo.dto.CouponDto;
import com.mrjeffapp.demo.dto.OrderDto;
import com.mrjeffapp.demo.dto.ProductDto;
import com.mrjeffapp.demo.entity.Coupon;
import com.mrjeffapp.demo.entity.Product;
import com.mrjeffapp.demo.repository.CouponRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderRestIntegrationTest {

    @Value("${local.server.port}")
    private int serverPort;

    @MockBean
    private CouponRepository couponRepository;

    private Coupon coupon;
    private CouponDto couponDto;

    private OrderDto orderDto;

    @Before
    public void setUp() {
        RestAssured.port = serverPort;
        coupon = new Coupon(1L, "", 5D);

        Product product1 = new Product(1L, 10D, "1");
        Product product2 = new Product(2L, 5D, "2");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        couponDto = new CouponDto(1L, "1", 5D);

        ProductDto productDto1 = new ProductDto(1L, 10D, "1");
        ProductDto productDto2 = new ProductDto(2L, 5D, "2");

        List<ProductDto> productsDto = new ArrayList<>();
        productsDto.add(productDto1);
        productsDto.add(productDto2);

        orderDto = new OrderDto(productsDto, couponDto);

    }

    @Test
    public void getPrice() {
        Mockito.when(couponRepository.findByCode(""))
                .thenReturn(Optional.ofNullable(coupon));

        given()
                .contentType(ContentType.JSON)
                .body(orderDto)
                .post(OrderController.BASE_PATH)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
