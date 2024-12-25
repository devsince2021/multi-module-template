package com.iwsaitw.utils.exception;

import com.iwsaitw.utils.exception.code.BaseExceptionCode;
import com.iwsaitw.utils.exception.fixture.BaseExceptionTestFixtures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseExceptionTest {

    @Test
    public void should_create_instance_with_code_and_message() {
        BaseExceptionCode code = BaseExceptionTestFixtures.createFailCode();
        BaseException ex = new BaseException(code);

        assertInstanceOf(BaseException.class, ex);
        assertInstanceOf(RuntimeException.class, ex);
        assertInstanceOf(Throwable.class, ex);
    }

    @Test
    public void should_return_message() {
        BaseExceptionCode code = BaseExceptionTestFixtures.createFailCode();
        BaseException ex = new BaseException(code);

        assertEquals(code.getMessage(), ex.getMessage());
    }

    @Test
    public void should_return_code() {
        BaseExceptionCode code = BaseExceptionTestFixtures.createFailCode();
        BaseException ex = new BaseException(code);

        assertTrue(ex.getCode().contains(code.getPrefix().getCode()));
        assertTrue(ex.getCode().contains(code.getCode()));
    }
}
