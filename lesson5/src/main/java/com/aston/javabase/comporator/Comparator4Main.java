package com.aston.javabase.comporator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator4Main {

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
        // мы можем использовать ссылку на метод
        Collections.sort(dogs, Comparator.comparing(Dog::getName));
//        Collections.sort(dogs, (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2)));
        Collections.sort(dogs, (c1, c2) -> "dogName".compareTo("dogName"));
        System.out.println(dogs);
    }
}
