package com.inditex.RestServicePriceProduct.application.services;

import com.inditex.RestServicePriceProduct.application.ports.out.PriceProductPersistencePort;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.PriceProductPersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceProductService {

    private final PriceProductPersistencePort priceProductPersistencePort;

    @Autowired
    public PriceProductService(PriceProductPersistenceAdapter priceProductPersistenceAdapter){
        this.priceProductPersistencePort = priceProductPersistenceAdapter;
    }


    public PriceResponse getAllPricesByPriceRequest(PriceRequest priceRequest){
        return priceProductPersistencePort.getAllPricesByPriceRequest(priceRequest);
    }
}
