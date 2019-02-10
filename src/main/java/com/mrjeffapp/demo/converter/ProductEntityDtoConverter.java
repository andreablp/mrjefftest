package com.mrjeffapp.demo.converter;

import com.mrjeffapp.demo.dto.ProductDto;
import com.mrjeffapp.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityDtoConverter extends BaseEntityDtoConverter<Product, ProductDto> {

    public ProductEntityDtoConverter() {
        super(Product.class, ProductDto.class);
    }
}
