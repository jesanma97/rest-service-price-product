package com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.controllers;

import com.inditex.RestServicePriceProduct.application.ports.in.PriceProductConsultPort;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.PriceProductConsultAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceProductRestController {

    private final PriceProductConsultPort priceProductConsultPort;

    @Autowired
    public PriceProductRestController(PriceProductConsultAdapter priceProductConsultAdapter){
        this.priceProductConsultPort = priceProductConsultAdapter;
    }

    @GetMapping("/prices")
    public PriceResponse getAllPricesByPriceRequest(@RequestBody PriceRequest priceRequest){
        return priceProductConsultPort.getAllPricesByPriceRequest(priceRequest);
    }


}
