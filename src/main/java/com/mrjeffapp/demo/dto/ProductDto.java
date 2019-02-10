package com.mrjeffapp.demo.dto;

public class ProductDto {

    private Long id;

    private Double price;

    private String code;

    public ProductDto(Long id, Double price, String code) {
        this.id = id;
        this.price = price;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
