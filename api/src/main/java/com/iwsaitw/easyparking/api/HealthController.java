package com.iwsaitw.easyparking.api;

import com.iwsaitw.easyparking.application.SampleService;
import com.iwsaitw.easyparking.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/exception")
    public void checkException() {
        throw new BaseException("test", "it is test");
    }

    @PostMapping("/sample")
    public void createSample() {
        sampleService.createSample();
    }
}
