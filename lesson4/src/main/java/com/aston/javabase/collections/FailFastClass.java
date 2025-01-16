package com.aston.javabase.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastClass {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            numbers.add(50);
        } // ConcurrentModificationException
    }
}
// хорошая статья
// https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator
