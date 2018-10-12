package com.work.vladimirs.entities.animals;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
