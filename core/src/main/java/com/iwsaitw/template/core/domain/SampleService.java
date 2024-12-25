package com.iwsaitw.template.core.domain;

public interface SampleService {
    String test();

    void throwBaseException();

    SampleDomain createSample(String name);
}
