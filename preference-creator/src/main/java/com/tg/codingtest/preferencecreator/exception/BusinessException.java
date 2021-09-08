package com.tg.codingtest.preferencecreator.exception;

import com.tg.codingtest.preferencecreator.common.enums.ExceptionType;
import lombok.Getter;

/**
 * Exception class to throw in case of any business logic.
 */

@Getter
public class BusinessException extends RuntimeException {
    private ExceptionType exceptionType;

    public BusinessException(ExceptionType exceptionType) {
        super(exceptionType.getErrorMessage());
        this.exceptionType=exceptionType;
    }
}
