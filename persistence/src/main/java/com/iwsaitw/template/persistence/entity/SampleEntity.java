package com.iwsaitw.template.persistence.entity;

import com.iwsaitw.template.persistence.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "sample")
public class SampleEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    public SampleEntity() {
    }

    public SampleEntity(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalStateException("name is required");
        }

        this.name = name;
    }

    public SampleEntity(Long id, String name) {
        super(id);

        if (Objects.isNull(name)) {
            throw new IllegalStateException("name is required");
        }

        this.name = name;
    }

    public Long getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
