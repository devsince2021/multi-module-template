package com.iwsaitw.easyparking.persistence;

import com.iwsaitw.easyparking.persistence.entity.SampleEntity;
import org.springframework.data.repository.CrudRepository;


public interface SampleJpaRepository extends CrudRepository<SampleEntity, Long> {
}
