package com.iwsaitw.template.application;

import com.iwsaitw.template.core.domain.SampleDomain;
import com.iwsaitw.template.core.domain.SampleService;
import com.iwsaitw.base.domain.exception.BaseException;
import com.iwsaitw.base.domain.exception.code.GeneralExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public String test() {
        SampleDomain instance = new SampleDomain("work");
        return instance.getName();
    }

    public void throwBaseException() {
        throw new BaseException(GeneralExceptionCode.II001);
    }

    public SampleDomain createSample(String name) {
        SampleDomain domain = new SampleDomain(name);
        SampleDomain savedDomain = sampleRepository.save(domain);
        return savedDomain;
    }
}
