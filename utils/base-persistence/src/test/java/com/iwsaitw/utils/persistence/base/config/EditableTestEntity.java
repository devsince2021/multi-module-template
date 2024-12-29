package com.iwsaitw.utils.persistence.base.config;

import com.iwsaitw.utils.persistence.base.EditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "EditTestEntity")
public class EditableTestEntity extends EditableEntity {
    private String name;

    public EditableTestEntity(String name) {
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
