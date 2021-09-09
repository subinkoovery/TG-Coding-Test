package com.tg.codingtest.preferencecreator.service.impl;

import com.tg.codingtest.preferencecreator.BaseTest;
import com.tg.codingtest.preferencecreator.model.CustomerDto;
import com.tg.codingtest.preferencecreator.repository.CustomerRepository;
import com.tg.codingtest.preferencecreator.repository.entity.CustomerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest extends BaseTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void createCustomerTest() {
        String name = "Test customer";
        String userName = "Test customer name";

        CustomerDto customerRequestDto = getCustomerDto(name, userName);

        Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class)))
                .thenReturn(null);

        CustomerDto customerDto = customerService.createCustomer(customerRequestDto);

        Assertions.assertNotNull(customerDto);


    }

    @Test
    public void updateCustomerTest() {


        String name = "Test customer";
        String userName = "Test customer name";
        Long customerId = 11l;


        CustomerEntity customerEntity =
                getCustomerEntity(name, userName, customerId);
        CustomerDto customerRequestDto = getCustomerDto(name, userName);

        Mockito.when(customerRepository.findById(Mockito.any(Long.class)))
                .thenReturn(Optional.of(customerEntity));

        Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class)))
                .thenReturn(null);

        CustomerDto customerDto = customerService.updateCustomer(customerRequestDto);

        Assertions.assertNotNull(customerDto);


    }

    @Test
    public void getCustomerTest() {

        Long customerId = 11l;
        CustomerEntity customerEntity =
                getCustomerEntity("TestUSer", "TestUserName", customerId);
        Mockito.when(customerRepository.findById(Mockito.any(Long.class)))
                .thenReturn(Optional.of(customerEntity));
        CustomerDto customerDto = customerService.getCustomer(customerId);
        Assertions.assertNotNull(customerDto);
    }

    @Test
    public void getCustomerListTest() {

        Long customerId = 11l;
        CustomerEntity customerEntity =
                getCustomerEntity("TestUSer", "TestUserName", customerId);
        CustomerEntity[] customerEntities = new CustomerEntity[1];
        customerEntities[0] = customerEntity;

        Mockito.when(customerRepository.findAll())
                .thenReturn(Arrays.asList(customerEntities));
        List<CustomerDto> customerDtos = customerService.getCustomerList();
        Assertions.assertNotNull(customerDtos);
    }


}
