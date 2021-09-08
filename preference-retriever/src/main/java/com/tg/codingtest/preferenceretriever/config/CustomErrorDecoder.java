package com.tg.codingtest.preferenceretriever.config;

import com.tg.codingtest.preferenceretriever.exception.ExternalServiceException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String requestUrl = response.request().url();
        Response.Body responseBody = response.body();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        return new ExternalServiceException(responseBody.toString(), responseStatus);
    }
}