package com.tg.codingtest.preferencecreator.controller;

import com.tg.codingtest.preferencecreator.common.AppConstant;
import com.tg.codingtest.preferencecreator.model.CustomerDto;
import com.tg.codingtest.preferencecreator.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.tg.codingtest.preferencecreator.common.AppConstant.URL.CUSTOMER_ID;

/**
 * This class is to hold controller method to create/update customer.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(AppConstant.URL.BASE_URL + AppConstant.URL.CUSTOMER)
@Api("API to manage customer detail.")
public class CustomerController {

    private final CustomerService customerService;

    @ApiOperation("API Endpoint to create customer.")
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer) {

        return ResponseEntity.ok().body(customerService.createCustomer(customer));
    }

    @ApiOperation("API Endpoint to update customer.")
    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customer) {

        return ResponseEntity.ok().body(customerService.updateCustomer(customer));
    }

    @ApiOperation("API Endpoint to retrieve details of a customer.")
    @GetMapping(CUSTOMER_ID)
    public ResponseEntity<CustomerDto> getCustomer(@ApiParam("Id of the customer") @PathVariable("customerId") Long customerId) {

        return ResponseEntity.ok().body(customerService.getCustomer(customerId));
    }

    @ApiOperation("API Endpoint to retrieve all customers.")
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomerList() {

        return ResponseEntity.ok().body(customerService.getCustomerList());

    }
}
