package com.aston.javabase.comparable_comparator;

import com.aston.javabase.collections.Dog;

import java.util.*;

public class ComparatorMain {

    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(
            new Dog("Dog", 3),
            new Dog("Dog", 2),
            new Dog("Dog", 1),
            new Dog("Asole", 2),
            new Dog("Amur", 1)
        );
        System.out.println(dogs);

        Collections.sort(dogs, new DogNameComparator() {});
        System.out.println(dogs);

        Collections.sort(dogs, new DogNameComparator().thenComparing(new DogAgeComparator() {}));
        System.out.println(dogs);
    }
}
