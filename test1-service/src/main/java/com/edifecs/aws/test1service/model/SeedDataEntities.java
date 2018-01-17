package com.edifecs.aws.test1service.model;

import java.util.List;

public class SeedDataEntities {

    private String type;
    private List<String> seedDataEntities;

    public SeedDataEntities() {
    }

    public SeedDataEntities(String type, List<String> seedDataEntities) {
        this.type = type;
        this.seedDataEntities = seedDataEntities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSeedDataEntities() {
        return seedDataEntities;
    }

    public void setSeedDataEntities(List<String> seedDataEntities) {
        this.seedDataEntities = seedDataEntities;
    }
}
