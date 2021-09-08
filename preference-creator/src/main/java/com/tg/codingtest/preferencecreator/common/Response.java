package com.tg.codingtest.preferencecreator.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tg.codingtest.preferencecreator.common.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private ResponseStatus status;
    private T data;
    private String errorCode;
    private String errorMessage;
}