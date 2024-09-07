package com.inditex.RestServicePriceProduct.application.ports.out;

import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.Price;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;

public interface PriceProductPersistencePort {
    PriceResponseDTO getPriceByPriceRequest(PriceRequest priceRequest);
}
