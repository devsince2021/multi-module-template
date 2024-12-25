package com.iwsaitw.utils.exception.code;

import com.iwsaitw.utils.exception.constant.BaseExceptionPrefix;

public interface BaseExceptionCode {
    BaseExceptionPrefix getPrefix();

    String getCode();

    String getMessage();
}
