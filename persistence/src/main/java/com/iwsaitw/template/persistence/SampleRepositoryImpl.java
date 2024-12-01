package com.iwsaitw.template.persistence;


import com.iwsaitw.template.application.SampleRepository;
import com.iwsaitw.template.core.domain.SampleDomain;
import com.iwsaitw.template.persistence.entity.SampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepositoryImpl implements SampleRepository {

    @Autowired
    private SampleJpaRepository sampleJpaRepository;

    @Override
    public SampleDomain save(SampleDomain domain) {
        System.out.println(domain.getName());

        SampleEntity entity = new SampleEntity();
        entity.setName(domain.getName());

        SampleEntity savedEntity = sampleJpaRepository.save(entity);

        SampleDomain newDomain = new SampleDomain(savedEntity.getName());
        newDomain.setId(savedEntity.getId());

        return newDomain;
    }
}
