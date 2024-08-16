package com.inditex.RestServicePriceProduct.application.ports.in;

import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;

import java.util.List;

public interface PriceProductConsultPort {

    PriceResponse getAllPricesByPriceRequest(PriceRequest priceRequest);
}
