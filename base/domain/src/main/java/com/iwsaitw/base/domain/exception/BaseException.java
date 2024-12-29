package com.iwsaitw.base.domain.exception;

import com.iwsaitw.base.domain.exception.code.BaseExceptionCode;

public class BaseException extends RuntimeException {
    private final BaseExceptionCode code;

    public BaseException(BaseExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public String getCode() {
        return this.code.getCode();
    }

    public String getMessage() {
        return this.code.getMessage();
    }
}