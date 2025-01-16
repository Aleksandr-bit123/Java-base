package com.aston.javabase.lambda;

import java.util.Collections;
import java.util.List;

public class LambdaMain {

    public static void main(String[] args) {
        System.out.println(sum(new int[] {0, 1, 0, 3, 0, 5, 0, 7, 0, 9}, n -> n != 0));
    }

    private static int sum(int[] numbers, Condition condition) {
        int result = 0;
        for (int i : numbers) {
            if (condition.isAppropriate(i)) {
                result += i;
            }
        }
        return result;
    }

    /*
     *  отсортировать список строк с помощью лямбда-выражения
     */
    public static List<String> sort(List<String> list){
        Collections.sort(list, (a, b) -> a.compareTo(b));
        return list;
    }

    public static List<String> sort2(List<String> list){
        Collections.sort(list, String::compareTo);
        return list;
    }
}
