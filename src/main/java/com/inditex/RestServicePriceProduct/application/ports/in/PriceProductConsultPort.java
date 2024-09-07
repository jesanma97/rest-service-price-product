package com.inditex.RestServicePriceProduct.application.ports.in;

import com.inditex.RestServicePriceProduct.domain.Price;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;

public interface PriceProductConsultPort {

    PriceResponseDTO getPriceByPriceRequest(PriceRequest priceRequest);
}
