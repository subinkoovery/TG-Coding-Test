package com.tg.codingtest.preferenceretriever.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Exception for dealing with external service error.
 */
@Getter
@AllArgsConstructor
public class ExternalServiceException extends RuntimeException {
    private String serviceErrorResponse;
    private HttpStatus httpStatus;
}
