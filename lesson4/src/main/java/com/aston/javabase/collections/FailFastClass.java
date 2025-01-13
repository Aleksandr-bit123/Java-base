package com.aston.javabase.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastClass {

    public static void main(String[] args) {

//        List<String> strings = new ArrayList<>();
//        strings.add("bbv");
//        strings.add("aav");
//        strings.add("ccv");

        removeStringsFromList("aa");
//        System.out.println(strings);
    }

    public static void removeStringsFromList(String string) {

        List<String> strings = new ArrayList<>();
        strings.add("bbv");
        strings.add("aav");
        strings.add("ccv");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {

            String next = iterator.next();
            if (next.startsWith(string)) {
                strings.remove(next);
            }
        }

/*        for (String str : list) {
            if (str.startsWith(string)) {
                list.remove(str);
            }
        }*/

    }
}
