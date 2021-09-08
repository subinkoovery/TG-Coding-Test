package com.tg.codingtest.preferencecreator.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionType {

    PREFERENCE_ALREADY_EXISTS("Preference already exists for this customer, please try updating preference"),
    PREFERENCE_DOES_NOT_EXISTS("Preference does not exists for this customer, please try creating preference"),
    CUSTOMER_DOES_NOT_EXIST("Customer does not exists, Please create customer first and retry.");

    String errorMessage;
}
