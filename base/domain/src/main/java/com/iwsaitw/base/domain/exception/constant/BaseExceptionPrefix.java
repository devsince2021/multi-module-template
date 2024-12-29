package com.iwsaitw.base.domain.exception.constant;

public enum BaseExceptionPrefix {
    FAIL("F400"),
    ERROR("E500");

    private final String code;

    BaseExceptionPrefix(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}