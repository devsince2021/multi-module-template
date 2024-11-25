package com.iwsaitw.easyparking.application;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public String test() {
        SampleDomain instance = new SampleDomain();

        return "work";
    }
}
