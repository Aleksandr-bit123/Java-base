package com.aston.javabase.comparable_comparator;

import com.aston.javabase.collections.Dog;

import java.util.Comparator;

public class DogAgeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dog1, Dog dog2) {
        return Integer.compare(dog1.getAge(), dog2.getAge());
    }
}
