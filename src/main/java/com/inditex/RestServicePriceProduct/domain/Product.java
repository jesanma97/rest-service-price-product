package com.inditex.RestServicePriceProduct.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {
    private long id;
    private String name;
    private List<Price> prices;
}
