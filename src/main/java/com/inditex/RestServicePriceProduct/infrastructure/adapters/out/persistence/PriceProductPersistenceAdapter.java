package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence;

import com.inditex.RestServicePriceProduct.application.ports.out.PriceProductPersistencePort;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.Price;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.dao.PriceProductDao;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers.PriceMapperEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers.PriceResponseDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceProductPersistenceAdapter implements PriceProductPersistencePort {

    private final PriceProductDao priceProductDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceProductPersistenceAdapter.class);

    @Autowired
    public PriceProductPersistenceAdapter(PriceProductDao priceProductDao){
        this.priceProductDao = priceProductDao;
    }

    @Override
    public PriceResponseDTO getPriceByPriceRequest(PriceRequest priceRequest) {
        PriceResponseDTO priceResponse = new PriceResponseDTO();

        try{
            PriceEntity priceEntity = PriceMapperEntity.INSTANCE.priceRequestToPriceEntity(priceRequest);
            priceEntity = priceProductDao.getPriceByPriceEntityAndApplicationDate(priceEntity, priceRequest.getApplicationDate());
            Price priceDomain = PriceMapperEntity.INSTANCE.priceEntityToPrice(priceEntity);
            priceResponse = PriceResponseDTOMapper.INSTANCE.priceDomainToPriceResponseDTO(priceDomain);
        }catch (Exception e){
            LOGGER.error("An error occurred while trying to obtain the price information");
        }

        return priceResponse;
    }
}
