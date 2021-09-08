package com.tg.codingtest.preferencecreator.controller;

import com.tg.codingtest.preferencecreator.common.AppConstant;
import com.tg.codingtest.preferencecreator.common.Response;
import com.tg.codingtest.preferencecreator.common.enums.ResponseStatus;
import com.tg.codingtest.preferencecreator.model.PreferenceDto;
import com.tg.codingtest.preferencecreator.service.PreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This class is to hold controller method to create and update preferences.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(AppConstant.URL.BASE_URL + AppConstant.URL.PREFERENCE)
public class CustomerPreferenceController {

    private final PreferenceService preferenceService;

    /**
     * Controller method to create preference.
     *
     * @param preferenceDto
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> createPreference(@Valid @RequestBody PreferenceDto preferenceDto) {

        preferenceService.createCustomerPreference(preferenceDto);
        return ResponseEntity.ok().body(Response.builder()
                .status(ResponseStatus.SUCCESS)
                .build());
    }


    /**
     * Controller method to update preference
     *
     * @param preferenceDto Preference detail
     * @return
     */
    @PutMapping
    public ResponseEntity<Response> updatePreference(@Valid @RequestBody PreferenceDto preferenceDto) {

        preferenceService.updateCustomerPreference(preferenceDto);
        return ResponseEntity.ok().body(Response.builder()
                .status(ResponseStatus.SUCCESS)
                .build());

    }

    /**
     * Controller method to get preference
     *
     * @param customerId Id of the customer
     * @return PreferenceDto
     */
    @GetMapping
    public ResponseEntity<PreferenceDto> getPreference(@RequestParam("customerId") Long customerId) {

        return ResponseEntity.ok(preferenceService.retrieveCustomerPreference(customerId));
    }
}
