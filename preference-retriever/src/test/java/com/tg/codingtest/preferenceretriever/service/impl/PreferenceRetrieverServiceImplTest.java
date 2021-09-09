package com.tg.codingtest.preferenceretriever.service.impl;

import com.tg.codingtest.preferenceretriever.client.PreferenceClient;
import com.tg.codingtest.preferenceretriever.common.enums.PreferenceType;
import com.tg.codingtest.preferenceretriever.model.PreferenceDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PreferenceRetrieverServiceImplTest {

    @InjectMocks
    private PreferenceRetrieverServiceImpl preferenceRetrieverService;

    @Mock
    private PreferenceClient preferenceClient;

    @Test
    public void getCustomerPreference() {

        PreferenceDto preferenceDto = PreferenceDto.builder()
                .customerId(1l)
                .preferenceType(PreferenceType.SMS)
                .build();

        Mockito.when(preferenceClient.getCustomerPreference(1l))
                .thenReturn(preferenceDto);

        Assertions.assertNotNull(preferenceRetrieverService.getCustomerPreference(1l));

    }
}
