package com.iwsaitw.easyparking.utils.exception;

// TODO: BaseExceptionCode 구현할 것
public class BaseException extends RuntimeException {
    private final String code;

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}