package com.aston.javabase.method_reference;

public class MethodReferenceMain {

    public static void main(String[] args) {

        Measurable lambda = n -> n.length();
        Measurable lambda2 = n -> n.compareTo("");
        Measurable reference = String::length;
//        Measurable reference2 = String::compareTo;

        System.out.println(lambda.measurableMethod("abc")); // 3
        System.out.println(reference.measurableMethod("abc")); // 3
    }
}
