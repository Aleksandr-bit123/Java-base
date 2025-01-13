package com.aston.javabase.generics;

import com.aston.javabase.generics.animals.Animal;
import com.aston.javabase.generics.animals.Cat;
import com.aston.javabase.generics.animals.Dog;

import java.util.ArrayList;
import java.util.List;

public class WildcardsMain {

    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Musya"));
        cats.add(new Cat("Lilu"));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Dog1"));
        dogs.add(new Dog("Dog2"));

        fight(cats, dogs);
    }

    private static void fight(List<? extends Animal> animals1, List<? extends Animal> animals2)
    {
//    private static void fight(List<Animal> animals1, List<Animal> animals2)

        System.out.println("fight " + animals1 + " and " + animals2);
    }
}
