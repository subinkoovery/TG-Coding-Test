package com.tg.codingtest.preferencecreator.exception;

import com.tg.codingtest.preferencecreator.common.Response;
import com.tg.codingtest.preferencecreator.common.enums.ResponseStatus;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
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

}
