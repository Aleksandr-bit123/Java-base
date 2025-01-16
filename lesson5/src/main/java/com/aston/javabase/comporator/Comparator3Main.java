package com.aston.javabase.comporator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator3Main {

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
        // мы можем использовать Лямбда-выражения
        Comparator<Dog> dogComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

        Collections.sort(dogs, dogComparator);
        Collections.sort(dogs, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(dogs);

    }
}
