package com.tg.codingtest.preferencecreator.service.impl;

import com.tg.codingtest.preferencecreator.common.enums.ExceptionType;
import com.tg.codingtest.preferencecreator.exception.BusinessException;
import com.tg.codingtest.preferencecreator.model.PreferenceDto;
import com.tg.codingtest.preferencecreator.repository.CustomerRepository;
import com.tg.codingtest.preferencecreator.repository.PreferenceRepository;
import com.tg.codingtest.preferencecreator.repository.entity.CustomerEntity;
import com.tg.codingtest.preferencecreator.repository.entity.PreferenceEntity;
import com.tg.codingtest.preferencecreator.service.PreferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.tg.codingtest.preferencecreator.common.enums.ExceptionType.CUSTOMER_DOES_NOT_EXIST;
import static com.tg.codingtest.preferencecreator.common.enums.ExceptionType.PREFERENCE_DOES_NOT_EXISTS;

/**
 * Service layer for customer preference
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createCustomerPreference(PreferenceDto preferenceDto) {

        CustomerEntity customerEntity = customerRepository.findById(preferenceDto.getCustomerId())
                .orElseThrow(() -> new BusinessException(CUSTOMER_DOES_NOT_EXIST));

        log.info("Customer detail:'{}'", customerEntity);

        //Throwing error if the preference already exists
        preferenceRepository.findByCustomer_Id(preferenceDto.getCustomerId())
                .ifPresent(preferenceEntity -> {
                    throw new BusinessException(ExceptionType.PREFERENCE_ALREADY_EXISTS);
                });

        PreferenceEntity preferenceEntity = PreferenceEntity.builder()
                .preferenceType(preferenceDto.getPreferenceType())
                .customer(customerEntity)
                .creationTime(LocalDateTime.now())
                .createdBy(preferenceDto.getCreatedOrUpdatedBy())
                .build();

        preferenceRepository.save(preferenceEntity);


    }

    @Override
    public void updateCustomerPreference(PreferenceDto preferenceDto) {

        PreferenceEntity preferenceEntity = preferenceRepository.findByCustomer_Id(preferenceDto.getCustomerId())
                .orElseThrow(() -> new BusinessException(PREFERENCE_DOES_NOT_EXISTS));

        preferenceEntity.setPreferenceType(preferenceDto.getPreferenceType());
        preferenceEntity.setModifiedBy(preferenceDto.getCreatedOrUpdatedBy());
        preferenceEntity.setModifiedTime(LocalDateTime.now());

        preferenceRepository.save(preferenceEntity);

    }

    @Override
    public PreferenceDto retrieveCustomerPreference(Long customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException(CUSTOMER_DOES_NOT_EXIST));

        PreferenceEntity preferenceEntity = preferenceRepository.findByCustomer_Id(customerId)
                .orElseThrow(() -> new BusinessException(PREFERENCE_DOES_NOT_EXISTS));

        return PreferenceDto.builder()
                .customerId(customerEntity.getId())
                .preferenceType(preferenceEntity.getPreferenceType())
                .build();
    }
}
