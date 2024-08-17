package com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.controllers;

import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.PriceProductConsultAdapter;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceProductRestControllerTest {

    @Mock
    private PriceProductConsultAdapter priceProductConsultAdapter;

    @InjectMocks
    private PriceProductRestController priceProductRestController;

    PriceResponse priceResponse;
    PriceRequest priceRequest;

    @BeforeEach
    public void setUp(){
        this.priceProductRestController = new PriceProductRestController(priceProductConsultAdapter);

        priceResponse = new PriceResponse();
        priceRequest = new PriceRequest();
        priceResponse.setPrice(38.95);
        priceResponse.setIdBrand(1L);
        priceResponse.setIdProduct(35455L);
        priceResponse.setIdPrice(4L);
        String startDate = "2020-06-15-16.00.00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime localDateTimeStartDate = LocalDateTime.parse(startDate, formatter);
        priceResponse.setStartDate(localDateTimeStartDate);
        String endDate = "2020-06-15-18.00.00";
        DateTimeFormatter formatterEndDate = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime localDateTimeEndDate = LocalDateTime.parse(endDate, formatterEndDate);
        priceResponse.setEndDate(localDateTimeEndDate);

        priceRequest.setIdProduct(35455L);
        priceRequest.setIdBrand(1L);
        priceRequest.setApplicationDate(localDateTimeStartDate);
    }

    @Test
    @DisplayName("Test getAllPricesByPriceRequest")
    void getAllPricesByPriceRequest(){
        when(this.priceProductConsultAdapter.getAllPricesByPriceRequest(Mockito.any())).thenReturn(priceResponse);
        PriceResponse response = priceProductRestController.getAllPricesByPriceRequest(priceRequest);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getIdProduct(), priceResponse.getIdProduct());
        Assertions.assertEquals(response.getPrice(), priceResponse.getPrice());
        Assertions.assertEquals(response.getIdPrice(), priceResponse.getIdPrice());
        Assertions.assertEquals(response.getIdBrand(), priceResponse.getIdBrand());
    }

}
