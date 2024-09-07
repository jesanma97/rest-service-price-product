package com.inditex.RestServicePriceProduct.application.services;

import com.inditex.RestServicePriceProduct.application.ports.out.PriceProductPersistencePort;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.PriceProductPersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceProductService {

    private final PriceProductPersistencePort priceProductPersistencePort;

    @Autowired
    public PriceProductService(PriceProductPersistenceAdapter priceProductPersistenceAdapter){
        this.priceProductPersistencePort = priceProductPersistenceAdapter;
    }


    public PriceResponseDTO getPriceByPriceRequest(PriceRequest priceRequest){
        return priceProductPersistencePort.getPriceByPriceRequest(priceRequest);
    }
}
