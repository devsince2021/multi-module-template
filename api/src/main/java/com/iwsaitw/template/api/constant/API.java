package com.iwsaitw.template.api.constant;

public class API {
    private static final String PREFIX = "/api";

    private static final class Domain {
        private static final String HEALTH = "/health";
        private static final String SAMPLE = "/sample";
    }

    public static final class V1 {
        private static final String V1 = "/v1";

        public static final String HEALTH = PREFIX + V1 + Domain.HEALTH;
        public static final String SAMPLE = PREFIX + V1 + Domain.SAMPLE;
    }
}
