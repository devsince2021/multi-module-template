package com.iwsaitw.base.persistence.base.config;

import com.iwsaitw.base.persistence.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BaseTestEntity")
public class BaseTestEntity extends BaseEntity {
    private String name;

    public BaseTestEntity(String name) {
        this.name = name;
    }
}
