package com.aston.javabase.generics.animals;

import com.aston.javabase.generics.example.MyInterface;

public abstract class Animal {

    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
