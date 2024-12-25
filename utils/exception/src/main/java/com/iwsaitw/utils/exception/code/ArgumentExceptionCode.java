package com.iwsaitw.utils.exception.code;

import com.iwsaitw.utils.exception.constant.BaseExceptionPrefix;

public enum ArgumentExceptionCode implements BaseExceptionCode {
    WA001(BaseExceptionPrefix.FAIL, "It has illegal argument");

    private final BaseExceptionPrefix prefix;
    private final String message;

    ArgumentExceptionCode(BaseExceptionPrefix prefix, String message) {
        this.prefix = prefix;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public BaseExceptionPrefix getPrefix() {
        return this.prefix;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
