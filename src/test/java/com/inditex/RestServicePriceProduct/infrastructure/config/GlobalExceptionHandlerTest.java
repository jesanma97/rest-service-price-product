package com.inditex.RestServicePriceProduct.infrastructure.config;

import com.inditex.RestServicePriceProduct.domain.ErrorResponse;
import com.inditex.RestServicePriceProduct.infrastructure.commons.exceptions.InvalidPriceRequestException;
import com.inditex.RestServicePriceProduct.infrastructure.config.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    public void handleValidationExceptionsTest() {
        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleValidationExceptions(ex);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCode().value());
        assertEquals("The request format is not correct. Please check it out", responseEntity.getBody().getMessage());
    }

    @Test
    public void handleInvalidPriceRequestExceptionTest() {
        InvalidPriceRequestException ex = new InvalidPriceRequestException("Invalid request data");
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleInvalidPriceRequestException(ex);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCode().value());
        assertEquals("Invalid request data", responseEntity.getBody().getMessage());
    }

    @Test
    public void handleJsonParseExceptionTest() {
        HttpMessageNotReadableException ex = mock(HttpMessageNotReadableException.class);
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleJsonParseException(ex);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCode().value());
        assertEquals("The request format is not correct. Please check it out", responseEntity.getBody().getMessage());
    }

    @Test
    public void handleInvalidHTTPMethodExceptionTest() {
        HttpRequestMethodNotSupportedException ex = mock(HttpRequestMethodNotSupportedException.class);
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleInvalidHTTPMethodException(ex);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), responseEntity.getStatusCode().value());
        assertEquals("Method not allowed to this request", responseEntity.getBody().getMessage());
    }
}
