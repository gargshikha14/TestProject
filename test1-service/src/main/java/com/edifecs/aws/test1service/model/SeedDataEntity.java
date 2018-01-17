package com.edifecs.aws.test1service.model;

import javax.persistence.*;

@Entity
@Table(name="seed_data_entity")
public class SeedDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    public SeedDataEntity() {
    }

    public SeedDataEntity(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
