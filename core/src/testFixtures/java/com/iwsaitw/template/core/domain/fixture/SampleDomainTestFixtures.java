package com.iwsaitw.template.core.domain.fixture;

import com.iwsaitw.template.core.domain.SampleDomain;

public class SampleDomainTestFixtures {
    private static final String validName = "name";

    public static SampleDomain createValidSampleDomain() {
        return new SampleDomain(validName);
    }
}
