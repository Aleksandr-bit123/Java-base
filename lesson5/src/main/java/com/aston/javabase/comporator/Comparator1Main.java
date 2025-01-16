package com.aston.javabase.comporator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Comparator1Main {

    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(
            new Dog("Dog", 3),
            new Dog("Dog", 2),
            new Dog("Dog", 1),
            new Dog("Asole", 2),
            new Dog("Amur", 1)
        );
        System.out.println(dogs);

        // если нам нужно отсортировать коллекцию,
        // мы можем использовать отдельный класс компаратор
        Collections.sort(dogs, new DogNameComparator() {});
        System.out.println(dogs);

    }
}
