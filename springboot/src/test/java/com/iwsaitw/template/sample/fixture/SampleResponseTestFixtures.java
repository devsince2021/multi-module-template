package com.iwsaitw.template.sample.fixture;

import com.iwsaitw.template.api.sample.SampleResponse;

public class SampleResponseTestFixtures {
    public static SampleResponse successResponse(String name) {
        return new SampleResponse(1L,name, 1L);
    }
}
