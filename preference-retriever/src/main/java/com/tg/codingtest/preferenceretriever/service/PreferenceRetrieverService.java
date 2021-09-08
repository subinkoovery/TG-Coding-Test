package com.tg.codingtest.preferenceretriever.service;

import com.tg.codingtest.preferenceretriever.model.PreferenceDto;

/**
 * Interface to retrieve preference
 */
public interface PreferenceRetrieverService {

    PreferenceDto getCustomerPreference(Long customerId);
}
