package com.iwsaitw.base.domain.exception.code;

import com.iwsaitw.base.domain.exception.constant.BaseExceptionPrefix;

public enum ArgumentExceptionCode implements BaseExceptionCode {
    WA001(BaseExceptionPrefix.FAIL, "must not be blank");

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
    public String getCode() {
        return this.prefix.getCode() + "-" + this.name();
    }
}
