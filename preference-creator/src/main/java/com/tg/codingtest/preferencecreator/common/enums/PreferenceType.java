package com.tg.codingtest.preferencecreator.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PreferenceType {

    POST("POST"),
    EMAIL("POST"),
    SMS("SMS");

    public String value;
}
