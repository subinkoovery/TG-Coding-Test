package com.tg.codingtest.preferenceretriever.service.impl;

import com.tg.codingtest.preferenceretriever.client.PreferenceClient;
import com.tg.codingtest.preferenceretriever.model.PreferenceDto;
import com.tg.codingtest.preferenceretriever.service.PreferenceRetrieverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for preference retrieve operations.
 */
@RequiredArgsConstructor
@Service
public class PreferenceRetrieverServiceImpl implements PreferenceRetrieverService {

    private final PreferenceClient preferenceClient;

    @Override
    public PreferenceDto getCustomerPreference(Long customerId) {
        return preferenceClient.getCustomerPreference(customerId);
    }
}
