package com.tg.codingtest.preferencecreator.model;

import com.tg.codingtest.preferencecreator.common.enums.PreferenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * DTO class to hold preference detail
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PreferenceDto {

    @NotNull
    private Long customerId;
    @NotNull
    private PreferenceType preferenceType;
    //Id of the operating-user who is doing operation.
    @NotNull
    private Long createdOrUpdatedBy;
}
