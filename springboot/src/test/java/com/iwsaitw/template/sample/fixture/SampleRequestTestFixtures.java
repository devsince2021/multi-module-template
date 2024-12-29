package com.iwsaitw.template.sample.fixture;

public class SampleRequestTestFixtures {
    private final static String name = "name";

    public static String createValidForm(String name) {
        return """
                {
                    "name": "%s"
                }
                """.formatted(name);
    }

    public static String createEmptyNameForm() {
        return """
                {
                    "name": "%s"
                }
                """.formatted("");
    }

}
