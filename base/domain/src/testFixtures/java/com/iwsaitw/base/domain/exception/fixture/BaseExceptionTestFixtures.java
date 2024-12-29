package com.iwsaitw.base.domain.exception.fixture;

import com.iwsaitw.base.domain.exception.code.BaseExceptionCode;
import com.iwsaitw.base.domain.exception.constant.BaseExceptionPrefix;

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
        public String getMessage() {
            return this.message;
        }

        @Override
        public String getCode() {
            return this.prefix.getCode() + "-" + this.code;
        }
    }

}
