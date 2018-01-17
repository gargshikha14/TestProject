package com.edifecs.aws.test1service.resource;

import com.edifecs.aws.test1service.model.SeedDataEntities;
import com.edifecs.aws.test1service.model.SeedDataEntity;
import com.edifecs.aws.test1service.repository.SeedDataRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/db")
public class DbServiceResource {

    private SeedDataRepository seedDataRepository;

    public DbServiceResource(SeedDataRepository seedDataRepository) {
        this.seedDataRepository = seedDataRepository;
    }

    @GetMapping("/{type}")
    public List<String> getNames(@PathVariable("type")
                         final String type){

        return getNamesByType(type);
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final SeedDataEntities seedDataEntities){

        seedDataEntities.getSeedDataEntities()
                .stream()
                .map(entity-> new SeedDataEntity(entity,seedDataEntities.getType()))
                .forEach(entity-> seedDataRepository.save(entity));

        return getNamesByType(seedDataEntities.getType());

    }

    @PostMapping("/delete/{type}")
    public List<String> delete(@PathVariable("type")
                               final String type){

        List<SeedDataEntity> seedDataEntities = seedDataRepository.findByType(type);
        seedDataRepository.delete(seedDataEntities);
        return getNamesByType(type);
    }

    private List<String> getNamesByType(@PathVariable("type") String type) {
        return seedDataRepository.findByType(type)
                .stream()
                .map(SeedDataEntity::getName)
                .collect(Collectors.toList());
    }

}
