package com.iwsaitw.template.core.domain;

import java.util.Objects;

public class SampleDomain {
    private SampleDomainId id;
    private String name;

    public SampleDomain(Long id, String name) {
        this.id = new SampleDomainId(id);
        this.name = name;
    }

    public SampleDomain(String name) {
        this.id = new SampleDomainId(null);
        this.name = name;
    }

    public Long getId() {
        Long sampleDomainId = id.getId();

        if (Objects.isNull(sampleDomainId)) {
            throw new IllegalStateException("ID는 null일 수 없습니다");
        }

        return sampleDomainId;
    }


    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = new SampleDomainId(id);
    }

    public void setName(String name) {
        this.name = name;
    }
}
