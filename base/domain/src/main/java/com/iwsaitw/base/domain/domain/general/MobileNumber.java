package com.iwsaitw.base.domain.domain.general;

import java.util.Objects;
import java.util.regex.Pattern;

public class MobileNumber {
    private static final String MOBILE_NUMBER_PATTERN = "^01[016789]-\\d{3,4}-\\d{4}$";

    private String value;

    private MobileNumber(String mobileNumber) {
        this.value = mobileNumber;
    }

    public static MobileNumber create(String mobileNumber) {
        if (!isValidFormat(mobileNumber)) {
            throw new IllegalArgumentException("잘못된 전화번호 형식입니다.");
        }

        return new MobileNumber(mobileNumber);
    }

    private static boolean isValidFormat(String target) {
        return Pattern.matches(MOBILE_NUMBER_PATTERN, target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobileNumber that = (MobileNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
