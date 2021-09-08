package com.tg.codingtest.preferencecreator.service.impl;

import com.tg.codingtest.preferencecreator.common.enums.ExceptionType;
import com.tg.codingtest.preferencecreator.exception.BusinessException;
import com.tg.codingtest.preferencecreator.model.CustomerDto;
import com.tg.codingtest.preferencecreator.repository.CustomerRepository;
import com.tg.codingtest.preferencecreator.repository.entity.CustomerEntity;
import com.tg.codingtest.preferencecreator.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * * Service layer for customer operations
 */
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customer) {

        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customer.getName())
                .userName(customer.getUserName())
                .createdBy(customer.getCreatedOrUpdatedBy())
                .creationTime(LocalDateTime.now())
                .build();

        customerRepository.save(customerEntity);

        customer.setId(customerEntity.getId());
        return customer;

    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customer) {

        CustomerEntity customerEntity = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new BusinessException(ExceptionType.CUSTOMER_DOES_NOT_EXIST));

        customerEntity.setName(customer.getName());
        customerEntity.setUserName(customer.getUserName());
        customerEntity.setModifiedBy(customer.getId());
        customerEntity.setModifiedTime(LocalDateTime.now());

        customerRepository.save(customerEntity);
        return customer;
    }

}
