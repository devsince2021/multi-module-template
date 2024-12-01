package com.iwsaitw.template.application;


import com.iwsaitw.template.core.domain.SampleDomain;

public interface SampleRepository {
    SampleDomain save(SampleDomain domain);
}
