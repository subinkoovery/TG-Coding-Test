package com.tg.codingtest.preferencecreator.service.impl;

import com.tg.codingtest.preferencecreator.BaseTest;
import com.tg.codingtest.preferencecreator.exception.BusinessException;
import com.tg.codingtest.preferencecreator.model.PreferenceDto;
import com.tg.codingtest.preferencecreator.repository.CustomerRepository;
import com.tg.codingtest.preferencecreator.repository.PreferenceRepository;
import com.tg.codingtest.preferencecreator.repository.entity.CustomerEntity;
import com.tg.codingtest.preferencecreator.repository.entity.PreferenceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.tg.codingtest.preferencecreator.common.enums.ExceptionType.PREFERENCE_ALREADY_EXISTS;

@ExtendWith(MockitoExtension.class)
public class PreferenceServiceImplTest extends BaseTest {

    @InjectMocks
    private PreferenceServiceImpl preferenceService;

    @Mock
    private PreferenceRepository preferenceRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void createCustomerPreferenceTest() {

        String name = "Test customer";
        String userName = "Test customer name";
        Long customerId = 11l;

        PreferenceDto preferenceDto = getPreferenceDto(customerId);

        CustomerEntity customerEntity =
                getCustomerEntity(name, userName, customerId);


        Mockito.when(customerRepository.findById(Mockito.any(Long.class)))
                .thenReturn(Optional.of(customerEntity));
        preferenceService.createCustomerPreference(preferenceDto);
    }

    @Test
    public void createCustomerPreferenceExceptionTest() {

        String name = "Test customer";
        String userName = "Test customer name";
        Long customerId = 11l;

        PreferenceDto preferenceDto = getPreferenceDto(customerId);

        CustomerEntity customerEntity =
                getCustomerEntity(name, userName, customerId);


        Mockito.when(customerRepository.findById(Mockito.any(Long.class)))
                .thenReturn(Optional.of(customerEntity));
        Mockito.when(preferenceRepository.findByCustomer_Id(customerId))
                .thenReturn(Optional.of(getPreferenceEntity(customerEntity)));

        BusinessException businessException = Assertions.assertThrows(BusinessException.class, () -> preferenceService.createCustomerPreference(preferenceDto));
        Assertions.assertEquals(PREFERENCE_ALREADY_EXISTS, businessException.getExceptionType());
    }


    @Test
    public void updateCustomerPreferenceTest() {

        String name = "Test customer";
        String userName = "Test customer name";
        Long customerId = 11l;

        PreferenceDto preferenceDto = getPreferenceDto(customerId);

        CustomerEntity customerEntity =
                getCustomerEntity(name, userName, customerId);

        PreferenceEntity preferenceEntity = getPreferenceEntity(customerEntity);

        Mockito.when(preferenceRepository.findByCustomer_Id(customerId))
                .thenReturn(Optional.of(preferenceEntity));

        preferenceService.updateCustomerPreference(preferenceDto);

    }


    @Test
    public void retrieveCustomerPreference() {

        String name = "Test customer";
        String userName = "Test customer name";
        Long customerId = 11l;

        CustomerEntity customerEntity =
                getCustomerEntity(name, userName, customerId);

        Mockito.when(customerRepository.findById(Mockito.any(Long.class)))
                .thenReturn(Optional.of(customerEntity));

        Mockito.when(preferenceRepository.findByCustomer_Id(customerId))
                .thenReturn(Optional.of(getPreferenceEntity(customerEntity)));

        Assertions.assertNotNull(preferenceService.retrieveCustomerPreference(customerId));


    }


}
