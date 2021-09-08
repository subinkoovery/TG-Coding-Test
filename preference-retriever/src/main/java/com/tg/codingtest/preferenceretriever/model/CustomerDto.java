package com.tg.codingtest.preferenceretriever.model;

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
public class CustomerDto {
    @NotNull
    private String name;
    @NotNull
    private String userName;

    @NotNull
    private Long createdOrUpdatedBy;

    private Long id;
}
