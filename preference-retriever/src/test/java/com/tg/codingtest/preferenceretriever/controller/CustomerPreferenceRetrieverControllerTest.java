package com.tg.codingtest.preferenceretriever.controller;

import com.tg.codingtest.preferenceretriever.model.PreferenceDto;
import com.tg.codingtest.preferenceretriever.service.PreferenceRetrieverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CustomerPreferenceRetrieverControllerTest {

    @InjectMocks
    private CustomerPreferenceRetrieverController customerPreferenceRetrieverController;

    @Mock
    private PreferenceRetrieverService preferenceRetrieverService;

    @Test
    public void getPreferenceTest() {

        ResponseEntity<PreferenceDto> responseEntity = customerPreferenceRetrieverController.getPreference(1l);
        Assertions.assertNotNull(responseEntity);
    }
}