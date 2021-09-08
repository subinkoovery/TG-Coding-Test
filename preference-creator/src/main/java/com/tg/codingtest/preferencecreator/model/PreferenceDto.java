package com.tg.codingtest.preferencecreator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tg.codingtest.preferencecreator.common.enums.PreferenceType;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("Preference detail")
public class PreferenceDto {

    @ApiModelProperty("Id of the customer")
    @NotNull
    private Long customerId;

    @ApiModelProperty("Preference type of customer, available types: POST,EMAIL,SMS")
    @NotNull
    private PreferenceType preferenceType;
    //Id of the operating-user who is doing operation.
    @NotNull
    private Long createdOrUpdatedBy;
}
