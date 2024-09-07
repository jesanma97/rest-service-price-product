package com.inditex.RestServicePriceProduct.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Brand {
    private long id;

    private String nameBrand;

    private List<Price> prices;
}
