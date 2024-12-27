package com.iwsaitw.utils.persistence.fixture.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EditableTestJpaRepository extends JpaRepository<EditableTestEntity, Long> {}

