package com.inditex.RestServicePriceProduct.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inditex.RestServicePriceProduct.infrastructure.commons.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Price {
    private long idPrice;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Product product;
    private double price;
    private Constants.Currency curr;
}
