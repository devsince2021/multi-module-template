package com.iwsaitw.template.persistence;

import com.iwsaitw.template.persistence.entity.SampleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface SampleJpaRepository extends CrudRepository<SampleEntity, Long> {
    Optional<SampleEntity> findByName(String name);
}
