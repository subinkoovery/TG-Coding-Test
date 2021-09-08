package com.tg.codingtest.preferenceretriever.model;

import com.tg.codingtest.preferenceretriever.common.enums.PreferenceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Preference detail")
public class PreferenceDto {

    @ApiModelProperty("Id of the customer")
    @NotNull
    private Long customerId;

    @ApiModelProperty("Preference type of customer, available types: POST,EMAIL,SMS")
    @NotNull
    private PreferenceType preferenceType;
}
