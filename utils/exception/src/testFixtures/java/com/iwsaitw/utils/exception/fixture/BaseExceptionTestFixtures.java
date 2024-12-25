package com.iwsaitw.utils.exception.fixture;

import com.iwsaitw.utils.exception.code.BaseExceptionCode;
import com.iwsaitw.utils.exception.constant.BaseExceptionPrefix;

public class BaseExceptionTestFixtures {
    public static BaseExceptionCode createFailCode() {
        return new BaseExceptionCodeImpl(BaseExceptionPrefix.FAIL, "TEST", "It is test");
    }

    private static class BaseExceptionCodeImpl implements BaseExceptionCode {
        private final BaseExceptionPrefix prefix;
        private final String code;
        private final String message;


        public BaseExceptionCodeImpl(BaseExceptionPrefix prefix, String code, String message) {
            this.prefix = prefix;
            this.code = code;
            this.message = message;
        }

        @Override
        public BaseExceptionPrefix getPrefix() {
            return this.prefix;
        }

        @Override
        public String getCode() {
            return this.code;
        }

        @Override
        public String getMessage() {
            return this.message;
        }
    }

}
