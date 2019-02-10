package com.mrjeffapp.demo.converter;

import com.mrjeffapp.demo.dto.CouponDto;
import com.mrjeffapp.demo.entity.Coupon;
import org.springframework.stereotype.Component;

@Component
public class CouponEntityDtoConverter extends BaseEntityDtoConverter<Coupon, CouponDto> {

    public CouponEntityDtoConverter() {
        super(Coupon.class, CouponDto.class);
    }
}
