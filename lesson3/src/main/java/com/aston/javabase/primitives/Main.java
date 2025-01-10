package com.aston.javabase.primitives;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] i = {1,2,3,4,5};

        String string = "Hello World!";
        String string1 = new String("Hello World!");
        string1.intern();


        int num = 5;
        Integer integer = 5;


        StringBuffer sb = new StringBuffer("Hello World!");

        StringBuilder sb1 = new StringBuilder("Hello World!");
        sb1.reverse();


//        printArray(i);

        equalsIntegersByLink();
        equalsIntegersByValue();
    }

    private static void equalsIntegersByLink() {
        Integer a = 1000;
        Integer b = 1000;

        System.out.println(a == b);
    }

    private static void equalsIntegersByValue() {
        Integer a = 1000;
        Integer b = 1000;

        System.out.println(a.equals(b));
    }

    private static void printArray(Integer[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
