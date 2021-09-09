package com.tg.codingtest.preferencecreator;

import com.tg.codingtest.preferencecreator.common.enums.PreferenceType;
import com.tg.codingtest.preferencecreator.model.CustomerDto;
import com.tg.codingtest.preferencecreator.model.PreferenceDto;
import com.tg.codingtest.preferencecreator.repository.entity.CustomerEntity;
import com.tg.codingtest.preferencecreator.repository.entity.PreferenceEntity;

import java.time.LocalDateTime;

/**
 * Class to hold common test methods
 */
public class BaseTest {
    public CustomerEntity getCustomerEntity(String name, String userName, Long customerId) {
        return CustomerEntity.builder()
                .id(customerId)
                .userName(userName)
                .name(name)
                .build();
    }

    public CustomerDto getCustomerDto(String name, String userName) {
        CustomerDto customerRequestDto = CustomerDto.builder()
                .name(name)
                .userName(userName)
                .createdOrUpdatedBy(1l)
                .id(1l)
                .build();
        return customerRequestDto;
    }

    public PreferenceDto getPreferenceDto(Long customerId) {
        return PreferenceDto.builder()
                .preferenceType(PreferenceType.SMS)
                .customerId(customerId)
                .createdOrUpdatedBy(1l)
                .build();
    }

    public PreferenceEntity getPreferenceEntity(CustomerEntity customerEntity) {
        PreferenceEntity preferenceEntity = PreferenceEntity.builder()
                .customer(customerEntity)
                .preferenceType(PreferenceType.SMS)
                .creationTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .modifiedBy(1l)
                .createdBy(1l)
                .build();
        return preferenceEntity;
    }
}
