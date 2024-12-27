package com.iwsaitw.utils.persistence.fixture.base;

import com.iwsaitw.utils.persistence.base.BaseEntity;
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
