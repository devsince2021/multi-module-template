package com.iwsaitw.base.domain.domain.general;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {
    private final String validPassword = "123456a!";

    @Test
    public void should_not_be_able_to_instantiate_by_constructor() {
        Constructor<?>[] constructors = Password.class.getDeclaredConstructors();

        Arrays.stream(constructors)
                .forEach(
                        (c) -> assertTrue(Modifier.isPrivate(c.getModifiers()))
                );
    }

    @Test
    public void should_have_value_field_as_private_String_type() throws NoSuchFieldException {
        Field field = Password.class.getDeclaredField("value");
        assertTrue(Modifier.isPrivate(field.getModifiers()));
        assertEquals(String.class, field.getType());
    }

    @Test
    public void should_instantiate_if_password_is_valid() {
        Password password = Password.create(validPassword);
        assertInstanceOf(Password.class, password);
    }

    @Test
    public void should_throw_exception_if_password_is_less_than_8_digit() {
        String shortPassword = "12345a!";
        assertThrows(IllegalArgumentException.class,
                () -> Password.create(shortPassword)
        );
    }

    @Test
    public void should_throw_exception_if_password_does_not_have_special_character() {
        String shortPassword = "1234567a";
        assertThrows(IllegalArgumentException.class,
                () -> Password.create(shortPassword)
        );
    }

    @Test
    public void should_throw_exception_if_password_does_not_have_alphabet() {
        String shortPassword = "1234567!";
        assertThrows(IllegalArgumentException.class,
                () -> Password.create(shortPassword)
        );
    }

    @Test
    public void should_be_equals_when_two_objects_have_same_password() {
        Password pw1 = Password.create(validPassword);
        Password pw2 = Password.create(validPassword);

        assertEquals(pw1, pw2);
    }
}
