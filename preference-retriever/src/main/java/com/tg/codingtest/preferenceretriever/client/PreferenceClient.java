package com.tg.codingtest.preferenceretriever.client;

import com.tg.codingtest.preferenceretriever.model.PreferenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client class to call feign creator service
 */
@FeignClient(url = "${app.service.preference-retriever-url}",name = "PreferenceClient")
public interface PreferenceClient {

    @GetMapping("/api/v1/preference")
    PreferenceDto getCustomerPreference(@RequestParam("customerId") Long customerId);
}
