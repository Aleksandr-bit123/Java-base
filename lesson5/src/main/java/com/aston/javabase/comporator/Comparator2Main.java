package com.aston.javabase.comporator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator2Main {

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
        // мы можем использовать Анонимный внутренний класс
        Comparator<Dog> dogComparator = new Comparator<Dog>() {

            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(dogs, dogComparator);
        System.out.println(dogs);

    }
}
