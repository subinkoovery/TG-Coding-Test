package com.tg.codingtest.preferencecreator.controller;

import com.tg.codingtest.preferencecreator.common.AppConstant;
import com.tg.codingtest.preferencecreator.common.Response;
import com.tg.codingtest.preferencecreator.common.enums.ResponseStatus;
import com.tg.codingtest.preferencecreator.model.PreferenceDto;
import com.tg.codingtest.preferencecreator.service.PreferenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "Customer Preference API", description = "API to manage customer preference.")
public class CustomerPreferenceController {

    private final PreferenceService preferenceService;

    @ApiOperation("API endpoint to create customer preference.")
    @PostMapping
    public ResponseEntity<Response> createPreference(@Valid @RequestBody PreferenceDto preferenceDto) {

        preferenceService.createCustomerPreference(preferenceDto);
        return ResponseEntity.ok().body(Response.builder()
                .status(ResponseStatus.SUCCESS)
                .build());
    }


    @ApiOperation("API endpoint to update customer preference.")
    @PutMapping
    public ResponseEntity<Response> updatePreference(@Valid @RequestBody PreferenceDto preferenceDto) {

        preferenceService.updateCustomerPreference(preferenceDto);
        return ResponseEntity.ok().body(Response.builder()
                .status(ResponseStatus.SUCCESS)
                .build());

    }

    @ApiOperation("API endpoint to retrieve preference of a customer.")
    @GetMapping
    public ResponseEntity<PreferenceDto> getPreference(@ApiParam("Id of the customer") @RequestParam("customerId") Long customerId) {

        return ResponseEntity.ok(preferenceService.retrieveCustomerPreference(customerId));
    }
}
