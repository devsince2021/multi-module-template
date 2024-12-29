package com.iwsaitw.template.api.sample;

public class SampleResponse {
    private Long id;
    private String name;
    private Long timestamp;

    public SampleResponse(Long id, String name, Long timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
