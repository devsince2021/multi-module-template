package com.iwsaitw.easyparking.application;

import com.iwsaitw.easyparking.core.domain.SampleDomain;
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

    public void createSample() {
        SampleDomain domain = new SampleDomain("work");
        SampleDomain savedDomain = sampleRepository.save(domain);
    }
}
