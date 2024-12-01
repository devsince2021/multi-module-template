package com.iwsaitw.template.persistence;

import com.iwsaitw.template.persistence.entity.SampleEntity;
import org.springframework.data.repository.CrudRepository;


public interface SampleJpaRepository extends CrudRepository<SampleEntity, Long> {
}
