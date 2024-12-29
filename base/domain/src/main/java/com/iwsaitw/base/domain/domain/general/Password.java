package com.iwsaitw.base.domain.domain.general;

import java.util.Objects;
import java.util.regex.Pattern;

public class Password {
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*[!@#$%^&*(),.?\":{}|<>])\\S{8,}$";

    private String value;

    private Password(String password) {
        this.value = password;
    }

    public static Password create(String password) {
        if (!isValidFormat(password)) {
            throw new IllegalArgumentException("password has invalid format");
        }

        return new Password(password);
    }

    private static boolean isValidFormat(String password) {
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
