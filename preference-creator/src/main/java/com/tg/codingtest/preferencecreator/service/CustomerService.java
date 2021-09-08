package com.tg.codingtest.preferencecreator.service;

import com.tg.codingtest.preferencecreator.model.CustomerDto;

import java.util.List;

/**
 * Interface for service layer for Customer related operations.
 */
public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customer);

    CustomerDto updateCustomer(CustomerDto customer);

    CustomerDto getCustomer(Long customerId);

    List<CustomerDto> getCustomerList();
}
