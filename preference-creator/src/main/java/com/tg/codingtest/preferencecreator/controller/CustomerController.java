package com.tg.codingtest.preferencecreator.controller;

import com.tg.codingtest.preferencecreator.common.AppConstant;
import com.tg.codingtest.preferencecreator.model.CustomerDto;
import com.tg.codingtest.preferencecreator.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This class is to hold controller method to create/update customer.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(AppConstant.URL.BASE_URL + AppConstant.URL.CUSTOMER)
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer) {

        return ResponseEntity.ok().body(customerService.createCustomer(customer));
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customer) {

        return ResponseEntity.ok().body(customerService.updateCustomer(customer));
    }
}
