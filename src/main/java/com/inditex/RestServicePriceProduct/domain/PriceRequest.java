package com.inditex.RestServicePriceProduct.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceRequest {
    @JsonProperty("application_date")
    private LocalDateTime applicationDate;
    @JsonProperty("id_product")
    private Long idProduct;
    @JsonProperty("id_brand")
    private Long idBrand;
}
