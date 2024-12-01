package com.iwsaitw.easyparking.application;

import com.iwsaitw.easyparking.core.domain.SampleDomain;
import com.iwsaitw.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public String test() {
        SampleDomain instance = new SampleDomain("work");
        return instance.getName();
    }

    public void throwBaseException() {
        throw new BaseException("test", "it is test");
    }

    public SampleDomain createSample(String name) {
        SampleDomain domain = new SampleDomain(name);
        SampleDomain savedDomain = sampleRepository.save(domain);
        return savedDomain;
    }
}
