package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence;

import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.dao.PriceProductDao;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.BrandEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.ProductEntity;
import com.inditex.RestServicePriceProduct.infrastructure.commons.Constants;
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
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceProductPersistenceAdapterTest {

    @Mock
    private PriceProductDao priceProductDao;

    @InjectMocks
    private PriceProductPersistenceAdapter priceProductPersistenceAdapter;

    PriceRequest priceRequest;
    PriceEntity priceEntity;

    @BeforeEach
    public void setUp(){
        this.priceProductPersistenceAdapter = new PriceProductPersistenceAdapter(priceProductDao);
        priceRequest = new PriceRequest();
        priceEntity = new PriceEntity();
        priceRequest.setIdProduct(35455L);
        priceRequest.setIdBrand(1L);
        String dateString = "2020-06-15-16.00.00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
        priceRequest.setApplicationDate(localDateTime);

        priceEntity.setProduct(new ProductEntity());
        priceEntity.getProduct().setId(35455L);
        priceEntity.setBrand(new BrandEntity());
        priceEntity.getBrand().setId(1);
        priceEntity.setIdPrice(1L);
        priceEntity.setStartDate(localDateTime);
        String endDate = "2020-06-15-18.00.00";
        DateTimeFormatter formatterEndDate = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime localDateTimeEndDate = LocalDateTime.parse(endDate, formatterEndDate);
        priceEntity.setEndDate(localDateTimeEndDate);
        priceEntity.setPrice(28.0);
        priceEntity.setCurr(Constants.Currency.EUR);
    }


    @Test
    @DisplayName("Test getAllPricesByPriceRequest Error")
    void getAllPricesByPriceRequestError(){
        when(this.priceProductDao.getAllPricesByPriceEntity(Mockito.any())).thenThrow(NullPointerException.class);
        PriceResponse response = priceProductPersistenceAdapter.getAllPricesByPriceRequest(priceRequest);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getIdPrice(), 0);
        Assertions.assertEquals(response.getIdBrand(), 0);
        Assertions.assertEquals(response.getIdProduct(), 0);
        Assertions.assertNull(response.getStartDate());
        Assertions.assertNull(response.getEndDate());
        Assertions.assertEquals(response.getPrice(), 0.0);
    }

    @Test
    @DisplayName("Test getAllPricesByPriceRequest Success")
    void getAllPricesByPriceRequestSuccess(){
        when(this.priceProductDao.getAllPricesByPriceEntity(Mockito.any())).thenReturn(List.of(priceEntity));
        PriceResponse response = priceProductPersistenceAdapter.getAllPricesByPriceRequest(priceRequest);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getIdPrice(), priceEntity.getIdPrice());
        Assertions.assertEquals(response.getIdBrand(), priceEntity.getBrand().getId());
        Assertions.assertEquals(response.getIdProduct(), priceEntity.getProduct().getId());
        Assertions.assertNotNull(response.getStartDate());
        Assertions.assertNotNull(response.getEndDate());
        Assertions.assertEquals(response.getPrice(), priceEntity.getPrice());
    }

}
