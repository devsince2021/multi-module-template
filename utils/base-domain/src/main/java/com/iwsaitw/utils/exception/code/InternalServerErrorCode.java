package com.iwsaitw.utils.exception.code;

import com.iwsaitw.utils.exception.constant.BaseExceptionPrefix;

public enum InternalServerErrorCode implements BaseExceptionCode {
    SE001(BaseExceptionPrefix.ERROR, "Unexpected server error occurs");

    private final BaseExceptionPrefix prefix;
    private final String message;

    InternalServerErrorCode(BaseExceptionPrefix prefix, String message) {
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
