package com.tg.codingtest.preferencecreator.controller;

import com.tg.codingtest.preferencecreator.BaseTest;
import com.tg.codingtest.preferencecreator.common.Response;
import com.tg.codingtest.preferencecreator.model.PreferenceDto;
import com.tg.codingtest.preferencecreator.service.PreferenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

/**
 * Junit class for CustomerPreferenceController
 */
@ExtendWith(MockitoExtension.class)
public class CustomerPreferenceControllerTest extends BaseTest {

    @Mock
    private PreferenceService preferenceService;

    @InjectMocks
    private CustomerPreferenceController customerPreferenceController;

    @Test
    public void createPreferenceTest() {

        PreferenceDto preferenceDto = getPreferenceDto(1l);
        ResponseEntity<Response> responseResponseEntity = customerPreferenceController.createPreference(preferenceDto);
        Assertions.assertNotNull(responseResponseEntity);
    }

    @Test
    public void updatePreferenceTest(){
        PreferenceDto preferenceDto = getPreferenceDto(1l);
        ResponseEntity<Response> responseResponseEntity = customerPreferenceController.updatePreference(preferenceDto);
        Assertions.assertNotNull(responseResponseEntity);
    }
    @Test
    public void getPreferenceTest(){
        ResponseEntity<PreferenceDto> preference = customerPreferenceController.getPreference(1l);
        Assertions.assertNotNull(preference);
    }

}
