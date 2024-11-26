package com.iwsaitw.easyparking.utils.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class BaseExceptionTest {

    @Test
    public void should_create_instance_with_code_and_message() {
        String code = "hello";
        String message = "it is msg";

        BaseException ex = new BaseException(code, message);

        assertInstanceOf(BaseException.class, ex);
        assertInstanceOf(RuntimeException.class, ex);
        assertInstanceOf(Throwable.class, ex);
    }

    @Test
    public void should_return_message() {
        String code = "hello";
        String message = "it is msg";

        BaseException ex = new BaseException(code, message);

        assertEquals(message, ex.getMessage());
    }

    @Test
    public void should_return_code() {
        String code = "hello";
        String message = "it is msg";

        BaseException ex = new BaseException(code, message);

        assertEquals(code, ex.getCode());
    }
}
