package com.inditex.RestServicePriceProduct.infrastructure.commons.exceptions;

public class InvalidPriceRequestException extends RuntimeException {

    public InvalidPriceRequestException(String message) {
        super(message);
    }
}
