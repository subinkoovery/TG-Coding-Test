package com.tg.codingtest.preferenceretriever.controller;

import com.tg.codingtest.preferenceretriever.common.AppConstant;
import com.tg.codingtest.preferenceretriever.model.PreferenceDto;
import com.tg.codingtest.preferenceretriever.service.PreferenceRetrieverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is to hold controller method to create/update customer.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(AppConstant.URL.BASE_URL + AppConstant.URL.PREFERENCE)
public class CustomerPreferenceRetrieverController {


    private final PreferenceRetrieverService preferenceRetrieverService;

    @GetMapping
    public ResponseEntity<PreferenceDto> getPreference(@RequestParam("customerId") Long customerId) {

        return ResponseEntity.ok(preferenceRetrieverService.getCustomerPreference(customerId));
    }
}
