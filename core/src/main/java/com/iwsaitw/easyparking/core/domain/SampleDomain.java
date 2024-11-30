package com.iwsaitw.easyparking.core.domain;

public class SampleDomain {
    private Long id;

    private String name;

    public SampleDomain(String name) {
        this.id = 0L;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
