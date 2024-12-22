package com.iwsaitw.template.persistence.base;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

interface BaseTestJpaRepository extends JpaRepository<BaseTestEntity, Long> {}

@Entity
@Table(name = "TestEntity")
class BaseTestEntity extends BaseEntity {
    private String name;

    public BaseTestEntity(String name) {
        this.name = name;
    }
}
