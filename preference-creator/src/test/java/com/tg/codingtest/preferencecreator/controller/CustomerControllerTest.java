package com.tg.codingtest.preferencecreator.controller;

import com.tg.codingtest.preferencecreator.BaseTest;
import com.tg.codingtest.preferencecreator.model.CustomerDto;
import com.tg.codingtest.preferencecreator.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Junit class for CustomerController
 */
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest extends BaseTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void createCustomerTest() {

        CustomerDto customerDto = getCustomerDto("TestName", "test");
        ResponseEntity<CustomerDto> customerDtoResponseEntity
                = customerController.createCustomer(customerDto);


        Assertions.assertNotNull(customerDtoResponseEntity);
    }

    @Test
    public void updateCustomerTest() {

        CustomerDto customerDto = getCustomerDto("TestName", "test");
        ResponseEntity<CustomerDto> customerDtoResponseEntity
                = customerController.updateCustomer(customerDto);


        Assertions.assertNotNull(customerDtoResponseEntity);
    }

    @Test
    public void getCustomerTest() {

        ResponseEntity<CustomerDto> customerDtoResponseEntity
                = customerController.getCustomer(1l);

        Assertions.assertNotNull(customerDtoResponseEntity);
    }


    @Test
    public void getCustomerList() {

        ResponseEntity<List<CustomerDto>> customerDtoResponseEntity
                = customerController.getCustomerList();

        Assertions.assertNotNull(customerDtoResponseEntity);
    }
}
