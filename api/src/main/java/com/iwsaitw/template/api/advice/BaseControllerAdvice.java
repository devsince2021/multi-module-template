package com.iwsaitw.template.api.advice;

import com.iwsaitw.base.web.BaseControllerExceptionHandler;
import com.iwsaitw.base.web.response.CustomError;
import com.iwsaitw.base.domain.exception.BaseException;
import com.iwsaitw.base.domain.exception.code.ArgumentExceptionCode;
import com.iwsaitw.base.web.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class BaseControllerAdvice {

    @Autowired
    private BaseControllerExceptionHandler exceptionHandler;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<CustomError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String firstCaseMessage = exceptionHandler.handleMethodArgumentNotValidException(exception);
        BaseException ex = new BaseException(ArgumentExceptionCode.WA001);

        return Response.fail(ex.getCode(), firstCaseMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseException.class)
    public Response<CustomError> handleBaseException(BaseException exception) {
        return Response.fail(exception.getCode(), exception.getMessage());
    }


}