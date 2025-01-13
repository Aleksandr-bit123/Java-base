package com.aston.javabase.collections;

import java.util.*;

public class CollectionsMain {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("John Smith", "value");

        checkArrayList();
//        checkLinkedList();
    }

    private static void checkArrayList() {
        long startMills = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(list.size()/2, i);
        }

        long currentMills = System.currentTimeMillis();
        System.out.println("Время выполнения в миллисекундах: " + (currentMills - startMills));
    } // Время выполнения в миллисекундах: 23 489

    private static void checkLinkedList() {
        long startMills = System.currentTimeMillis();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(list.size()/2, i);
        }

        long currentMills = System.currentTimeMillis();
        System.out.println("Время выполнения в миллисекундах: " + (currentMills - startMills));
    } // Время выполнения в миллисекундах: 1 679 579
}
