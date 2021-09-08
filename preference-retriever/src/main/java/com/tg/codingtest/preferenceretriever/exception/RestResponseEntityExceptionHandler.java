package com.tg.codingtest.preferenceretriever.exception;

import com.tg.codingtest.preferenceretriever.common.Response;
import com.tg.codingtest.preferenceretriever.common.enums.ResponseStatus;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response> handleAccessDeniedException(BusinessException bx, WebRequest request) {

        return new ResponseEntity<Response>(Response.builder()
                .status(ResponseStatus.ERROR)
                .errorCode(bx.getExceptionType().name())
                .errorMessage(bx.getExceptionType().getErrorMessage())
                .build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Advise method to handle external service call exception
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity handleExternalServiceException(ExternalServiceException ex, WebRequest request) {

        return ResponseEntity.status(ex.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ex.getServiceErrorResponse());

    }
}