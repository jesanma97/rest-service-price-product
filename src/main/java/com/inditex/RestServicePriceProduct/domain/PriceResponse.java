package com.inditex.RestServicePriceProduct.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceResponse {

    private long idBrand;
    private long idProduct;
    private long idPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
}
