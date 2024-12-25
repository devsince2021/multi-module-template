package com.iwsaitw.template.persistence.base;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

interface EditableTestJpaRepository extends JpaRepository<EditableTestEntity, Long> {}

@Entity
@Table(name = "EditTestEntity")
class EditableTestEntity extends EditableEntity {
    private String name;

    public EditableTestEntity(String name) {
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
