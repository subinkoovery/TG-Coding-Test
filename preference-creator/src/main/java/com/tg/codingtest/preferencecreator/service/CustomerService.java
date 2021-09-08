package com.tg.codingtest.preferencecreator.service;

import com.tg.codingtest.preferencecreator.model.CustomerDto;

/**
 * Interface for service layer for Customer related operations.
 */
public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customer);

    CustomerDto updateCustomer(CustomerDto customer);

}
