package com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web;

import com.inditex.RestServicePriceProduct.application.ports.in.PriceProductConsultPort;
import com.inditex.RestServicePriceProduct.application.services.PriceProductService;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceProductConsultAdapter implements PriceProductConsultPort {

    private final PriceProductService priceProductService;

    @Autowired
    public PriceProductConsultAdapter(PriceProductService priceProductService){
        this.priceProductService = priceProductService;
    }

    @Override
    public PriceResponse getAllPricesByPriceRequest(PriceRequest priceRequest){
        return priceProductService.getAllPricesByPriceRequest(priceRequest);
    }



}
