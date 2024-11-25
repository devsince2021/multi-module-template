package com.iwsaitw.easyparking.api;

import com.iwsaitw.easyparking.application.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/health")
    public String checkHealth() {
        String result = sampleService.test();
        System.out.println(result);

        return "Health";
    }
}
