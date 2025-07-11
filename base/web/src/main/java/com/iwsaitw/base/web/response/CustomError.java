package com.iwsaitw.base.web.response;

public class CustomError {
    private String code;
    private String message;

    public CustomError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
