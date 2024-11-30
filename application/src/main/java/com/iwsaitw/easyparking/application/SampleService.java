package com.iwsaitw.easyparking.application;

import com.iwsaitw.easyparking.core.domain.SampleDomain;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public String test() {
        SampleDomain instance = new SampleDomain("work");
        return instance.getName();
    }
}
