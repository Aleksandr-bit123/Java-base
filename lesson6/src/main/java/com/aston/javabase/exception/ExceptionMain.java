package com.aston.javabase.exception;

import java.util.Arrays;

public class ExceptionMain {

    public static void main(String[] args) {
//        int[] ints = {0, 1, 2, 3};
//        ints[5] = 5;

        tryCatchExampleMethod();
    }

    private static void tryCatchExampleMethod() {
        try {
            int[] ints = {0, 1, 2, 3};
            // пытаемся обратиться к несуществующему индексу
            ints[5] = 5;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("block catch");
                throw new RuntimeException(e.getMessage());
//            System.out.println("log ArrayIndexOutOfBoundsException");

        } catch (Exception exception) {
            System.out.println("log Exception");

        } finally {
            System.out.println("close connections");
        }
    }
}
