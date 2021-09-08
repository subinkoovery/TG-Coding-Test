package com.tg.codingtest.preferencecreator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {
    @ApiModelProperty("Name of the customer")
    @NotNull
    private String name;

    @ApiModelProperty("Username of the customer")
    @NotNull
    private String userName;

    @NotNull
    private Long createdOrUpdatedBy;

    @ApiModelProperty("ID of the customer")
    private Long id;
}
