package com.iwsaitw.utils.domain.base;

import com.iwsaitw.utils.exception.BaseException;
import com.iwsaitw.utils.exception.code.GeneralExceptionCode;

import java.util.Objects;

public class BaseId {
    private final Long value;

    protected BaseId(Long id) {
        if (Objects.nonNull(id) && id <= 0) {
            throw new BaseException(GeneralExceptionCode.II001);
        }

        this.value = id;
    }

    public Long getId() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId that = (BaseId) o;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }
}
