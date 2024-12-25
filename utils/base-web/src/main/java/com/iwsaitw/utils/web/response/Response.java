package com.iwsaitw.utils.web.response;

import com.iwsaitw.utils.exception.BaseException;

public class Response<T> {
    private final Result result;
    private final T data;
    private final CustomError error;


    private Response(Result result, T data, BaseException exception) {
        this.result = result;
        this.data = data;
        this.error = exception != null
                ? new CustomError(exception.getCode(), exception.getMessage())
                : null;
    }

    public Result getResult() {
        return result;
    }

    public T getData() {
        return data;
    }

    public CustomError getError() {
        return error;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(Result.SUCCESS, data, null);
    }

    public static Response<BaseException> fail(BaseException exception) {
        return new Response<>(Result.FAIL, null, exception);
    }
}
