package com.inditex.RestServicePriceProduct.application.ports.out;

import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;

import java.util.List;

public interface PriceProductPersistencePort {
    PriceResponse getAllPricesByPriceRequest(PriceRequest priceRequest);
}
