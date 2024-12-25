package com.iwsaitw.utils.web;

import com.iwsaitw.utils.web.response.CustomError;
import com.iwsaitw.utils.exception.BaseException;
import com.iwsaitw.utils.exception.code.ArgumentExceptionCode;
import com.iwsaitw.utils.web.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.MethodArgumentNotValidException;


/**
 * BaseException에 강한 의존이 걸려있으나, 예외처리 모듈로 가기에는 웹 레이어에서만 사용되어야함
 * 그렇다고 사용측에 직접 구현하기에는 비슷한 내용이 여러 프로젝트에서 사용될 것이라 고민됨.
 */

@RestControllerAdvice
public class BaseControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<CustomError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String firstCaseMessage = exception.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        ArgumentExceptionCode code = ArgumentExceptionCode.WA001;
        return Response.fail(code.getCode(), firstCaseMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseException.class)
    public Response<CustomError> handleBaseException(BaseException exception) {
        return Response.fail(exception.getCode(), exception.getMessage());
    }
}
