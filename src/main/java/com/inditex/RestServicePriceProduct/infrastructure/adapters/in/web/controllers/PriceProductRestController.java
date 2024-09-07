package com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.controllers;

import com.inditex.RestServicePriceProduct.application.ports.in.PriceProductConsultPort;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.PriceProductConsultAdapter;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;
import com.inditex.RestServicePriceProduct.infrastructure.commons.Endpoints;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoints.PARENT_URL)
public class PriceProductRestController {

    private final PriceProductConsultPort priceProductConsultPort;

    @Autowired
    public PriceProductRestController(PriceProductConsultAdapter priceProductConsultAdapter){
        this.priceProductConsultPort = priceProductConsultAdapter;
    }

    /**
     * Handles HTTP GET requests to retrieve pricing information based on the provided request data.
     *
     * @param priceRequest The request body containing the necessary parameters to search for pricing information.
     *                     This includes the application date, product ID, and brand ID. The request is validated
     *                     to ensure all required fields are present and correctly formatted.
     *
     * @return A `PriceResponse` object containing the pricing information that matches the criteria specified in
     *         the `priceRequest`. The response includes details like price, currency, and priority.
     *
     * @throws MethodArgumentNotValidException if the `priceRequest` fails validation, typically due to missing
     *                                         or incorrectly formatted fields.
     *
     * This method uses the `PriceProductConsultPort` interface to delegate the logic for retrieving the pricing
     * information from the underlying data sources.
     */
    @PostMapping(Endpoints.PRICES)
    public PriceResponseDTO getPriceByPriceRequest(@Valid @RequestBody PriceRequest priceRequest){
        return priceProductConsultPort.getPriceByPriceRequest(priceRequest);
    }


}
