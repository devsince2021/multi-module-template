package com.iwsaitw.utils.web.response;

public class Response<T> {
    private final Result result;
    private final T data;
    private final CustomError error;

    private Response(Result result, T data, CustomError error) {
        this.result = result;
        this.data = data;
        this.error = error;
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

    public static Response<CustomError> fail(String code, String message) {
        CustomError error = new CustomError(code, message);
        return new Response<>(Result.FAIL, null, error);
    }
}
