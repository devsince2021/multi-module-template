package com.iwsaitw.base.web;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Component
public class BaseControllerExceptionHandler {
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String firstCaseMessage = exception.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return firstCaseMessage;
    }
}
