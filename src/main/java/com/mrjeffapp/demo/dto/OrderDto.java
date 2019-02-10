package com.mrjeffapp.demo.dto;

import java.util.List;

public class OrderDto {

    private List<ProductDto> products;

    private CouponDto coupon;

    public OrderDto(List<ProductDto> products, CouponDto coupon) {
        this.products = products;
        this.coupon = coupon;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public CouponDto getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponDto coupon) {
        this.coupon = coupon;
    }
}
