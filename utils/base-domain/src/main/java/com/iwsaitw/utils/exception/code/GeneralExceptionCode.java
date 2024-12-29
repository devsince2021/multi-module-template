package com.iwsaitw.utils.exception.code;

import com.iwsaitw.utils.exception.constant.BaseExceptionPrefix;

public enum GeneralExceptionCode implements BaseExceptionCode {
    II001(BaseExceptionPrefix.FAIL, "should be positive number"),
    II002(BaseExceptionPrefix.FAIL, "should not be null");

    private final BaseExceptionPrefix prefix;
    private final String message;

    GeneralExceptionCode(BaseExceptionPrefix prefix, String message) {
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