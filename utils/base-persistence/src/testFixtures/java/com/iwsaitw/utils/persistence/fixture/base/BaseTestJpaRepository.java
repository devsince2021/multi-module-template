package com.iwsaitw.utils.persistence.fixture.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseTestJpaRepository extends JpaRepository<BaseTestEntity, Long> {}

