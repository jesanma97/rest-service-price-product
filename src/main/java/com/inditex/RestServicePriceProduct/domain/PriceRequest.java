package com.inditex.RestServicePriceProduct.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceRequest {
    private LocalDateTime applicationDate;
    private Long idProduct;
    private Long idBrand;
}
