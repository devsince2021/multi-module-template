package com.iwsaitw.template.api.sample;

public class SampleRequest {
    private String name;

    public SampleRequest() {
    }

    public SampleRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
