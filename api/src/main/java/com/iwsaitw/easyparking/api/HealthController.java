package com.iwsaitw.easyparking.api;

import com.iwsaitw.easyparking.application.SampleService;
import com.iwsaitw.easyparking.core.domain.SampleDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/health")
    public Map<String, String> checkHealth() {
        String result = sampleService.test();

        return Map.of("message", "Health");
    }

    @GetMapping("/exception")
    public void checkException() {
        sampleService.throwBaseException();
    }

    @PostMapping("/sample")
    public SampleDomain createSample(
            @RequestBody SampleRequest request
    ) {
        SampleDomain domain = sampleService.createSample(request.getName());
        return domain;
    }
}
