package com.tg.codingtest.preferencecreator.service;

import com.tg.codingtest.preferencecreator.model.PreferenceDto;

/**
 * Interface for service layer for preference related operations.
 */
public interface PreferenceService {

    void createCustomerPreference(PreferenceDto preferenceDto);

    void updateCustomerPreference(PreferenceDto preferenceDto);

    PreferenceDto retrieveCustomerPreference(Long customerId);
}
