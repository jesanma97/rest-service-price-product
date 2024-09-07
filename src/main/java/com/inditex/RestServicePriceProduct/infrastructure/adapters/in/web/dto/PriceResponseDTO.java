package com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceResponseDTO {
    @JsonProperty("id_brand")
    private long idBrand;
    @JsonProperty("id_product")
    private long idProduct;
    @JsonProperty("id_price")
    private long idPrice;
    @JsonProperty("start_date")
    private LocalDateTime startDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    private double price;
}
