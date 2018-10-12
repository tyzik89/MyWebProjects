package com.work.vladimirs.entities.animals;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String name = "Тузик";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
