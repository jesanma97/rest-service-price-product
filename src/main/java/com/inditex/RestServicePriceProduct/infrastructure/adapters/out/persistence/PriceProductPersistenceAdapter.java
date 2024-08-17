package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence;

import com.inditex.RestServicePriceProduct.application.ports.out.PriceProductPersistencePort;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.dao.PriceProductDao;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers.PriceMapperEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceProductPersistenceAdapter implements PriceProductPersistencePort {

    private final PriceProductDao priceProductDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceProductPersistenceAdapter.class);

    @Autowired
    public PriceProductPersistenceAdapter(PriceProductDao priceProductDao){
        this.priceProductDao = priceProductDao;
    }

    @Override
    public PriceResponse getAllPricesByPriceRequest(PriceRequest priceRequest) {
        PriceResponse priceResponse = new PriceResponse();

        try{
            PriceEntity priceEntity = PriceMapperEntity.INSTANCE.priceRequestToPriceEntity(priceRequest);
            List<PriceEntity> pricesEntityList = priceProductDao.getAllPricesByPriceEntity(priceEntity);
            priceEntity = pricesEntityList.stream().findFirst().orElse(null);
            priceResponse = PriceMapperEntity.INSTANCE.priceEntityToPriceResponse(priceEntity);
        }catch (Exception e){
            LOGGER.error("An error occurred while trying to obtain the price information");
        }

        return priceResponse;
    }
}
