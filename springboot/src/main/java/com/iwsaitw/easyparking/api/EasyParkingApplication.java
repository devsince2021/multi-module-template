package com.iwsaitw.easyparking.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.iwsaitw.easyparking")
public class EasyParkingApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyParkingApplication.class, args);
    }
}
