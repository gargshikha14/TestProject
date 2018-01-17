package com.edifecs.aws.test1service.repository;

import com.edifecs.aws.test1service.model.SeedDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SeedDataRepository extends JpaRepository<SeedDataEntity, Integer>{

    List<SeedDataEntity> findByType(String type);
}
