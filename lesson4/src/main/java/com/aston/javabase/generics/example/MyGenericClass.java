package com.aston.javabase.generics.example;

import com.aston.javabase.generics.animals.Animal;

//public class MyGenericClass<E> {

public class MyGenericClass<E extends Animal> {

    private final E animal;

    public MyGenericClass(E animal) {
        this.animal = animal;
    }

    public E getAnimal() {
        return animal;
    }

    public String getAnimalName() {
        return animal.getName();
    }
}

