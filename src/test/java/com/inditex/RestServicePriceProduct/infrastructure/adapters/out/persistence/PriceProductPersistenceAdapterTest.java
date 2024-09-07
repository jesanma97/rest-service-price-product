package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence;

import com.inditex.RestServicePriceProduct.domain.Price;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.dao.PriceProductDao;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.BrandEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.ProductEntity;
import com.inditex.RestServicePriceProduct.infrastructure.commons.Constants;
import com.inditex.RestServicePriceProduct.infrastructure.commons.exceptions.NotFoundPriceRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceProductPersistenceAdapterTest {

    @Mock
    private PriceProductDao priceProductDao;

    @InjectMocks
    private PriceProductPersistenceAdapter priceProductPersistenceAdapter;

    PriceRequest mockPriceRequest;
    PriceEntity mockPriceEntity;
    PriceEntity mockFoundPriceEntity;

    @BeforeEach
    void setUp() {
        priceProductPersistenceAdapter = new PriceProductPersistenceAdapter(priceProductDao);

        // Mock PriceRequest
        mockPriceRequest = new PriceRequest();
        mockPriceRequest.setIdProduct(1L);
        mockPriceRequest.setIdBrand(1L);
        mockPriceRequest.setApplicationDate(LocalDateTime.now());

        // Mock PriceEntity
        mockPriceEntity = new PriceEntity();
        mockPriceEntity.setIdPrice(1L);
        mockPriceEntity.setProduct(new ProductEntity());
        mockPriceEntity.getProduct().setId(35455L);
        mockPriceEntity.setBrand(new BrandEntity());
        mockPriceEntity.getBrand().setId(1);
        mockPriceEntity.setStartDate(LocalDateTime.now().minusDays(1));
        mockPriceEntity.setEndDate(LocalDateTime.now().plusDays(1));

        // Mock Found PriceEntity (from DB)
        mockFoundPriceEntity = new PriceEntity();
        mockFoundPriceEntity.setIdPrice(2L);  // Different ID to simulate found price
        mockFoundPriceEntity.setProduct(new ProductEntity());
        mockFoundPriceEntity.getProduct().setId(35455L);
        mockFoundPriceEntity.setBrand(new BrandEntity());
        mockFoundPriceEntity.getBrand().setId(1);
        mockFoundPriceEntity.setStartDate(LocalDateTime.now().minusDays(1));
        mockFoundPriceEntity.setEndDate(LocalDateTime.now().plusDays(1));
    }

    @Test
    void getPriceByPriceRequest_Success() {
        // Given: Mocking the DAO to return the found entity
        when(priceProductDao.getPriceByPriceEntityAndApplicationDate(any(PriceEntity.class), any(LocalDateTime.class)))
                .thenReturn(mockFoundPriceEntity);

        // When: Calling the method
        PriceResponseDTO responseDTO = priceProductPersistenceAdapter.getPriceByPriceRequest(mockPriceRequest);

        // Then: Asserting the results
        assertNotNull(responseDTO);
        assertEquals(2L, responseDTO.getIdPrice());  // Found price ID should be 2
        verify(priceProductDao, times(1))
                .getPriceByPriceEntityAndApplicationDate(any(PriceEntity.class), any(LocalDateTime.class));
    }

    @Test
    void getPriceByPriceRequest_NotFound() {
        // Given: Mocking the DAO to return null (no price found)
        when(priceProductDao.getPriceByPriceEntityAndApplicationDate(any(PriceEntity.class), any(LocalDateTime.class)))
                .thenReturn(null);

        // When: Asserting that the exception is thrown
        NotFoundPriceRequestException thrown = assertThrows(NotFoundPriceRequestException.class, () -> {
            priceProductPersistenceAdapter.getPriceByPriceRequest(mockPriceRequest);
        });

        // Then: Verifying the exception message
        assertEquals("No price found for the given parameters.", thrown.getMessage());
        verify(priceProductDao, times(1))
                .getPriceByPriceEntityAndApplicationDate(any(PriceEntity.class), any(LocalDateTime.class));
    }

}
