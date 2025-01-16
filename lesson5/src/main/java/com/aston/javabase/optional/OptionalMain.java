package com.aston.javabase.optional;

import com.aston.javabase.comporator.Dog;

import java.util.Arrays;
import java.util.List;

public class OptionalMain {

    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(
                new Dog("Dog", 3),
                new Dog("Dog", 2),
                new Dog("Dog", 1),
                new Dog("Asole", 2),
                new Dog("Amur", 1)
        );

        String string = getString(dogs);
    }

    public static String getString(List<Dog> list) {
        return list.stream()
                .filter(dog -> "Dog".equals(dog.getName()))
                .findFirst()
                .map(Dog::getName)
                .orElse(null);
    }
}
