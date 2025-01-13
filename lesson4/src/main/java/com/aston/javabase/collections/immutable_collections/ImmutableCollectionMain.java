package com.aston.javabase.collections.immutable_collections;

import java.util.*;
import java.util.stream.Collectors;

public class ImmutableCollectionMain {

    public static void main(String[] args) {

        /*
         * Для коллекции, содержащей данные, которые изменяются в ходе работы программы,
         * лучшим выбором является изменяемая коллекция.
         *
         * Коллекция считается неизменяемой, если элементы нельзя добавлять, удалять или заменять.
         * Неизменяемая коллекция обеспечивает экономию пространства и предотвращает случайное изменение коллекции,
         * которое может привести к неправильной работе программы.
         */

        // В JDK 8:

        // Возвращает список фиксированного размера, поддерживаемый указанным массивом.
        // Не разрешает изменить размер коллекции. Но дает изменить коллекцию.
        List<String> stringList = Arrays.asList("c", "a", "b");
//        stringList.add("d"); // UnsupportedOperationException
//        stringList.sort(String::compareTo); // stringList: [a, b, c]
//        stringList.set(0, "e"); // stringList: [e, a, b]
//        stringList.clear(); // UnsupportedOperationException
        System.out.println("stringList: " + stringList);

        // Возвращает неизменяемый вид указанного списка.
        List<String> unmodifiableListFromArray = Collections.unmodifiableList(stringList);
//        unmodifiableListFromArray.add("D"); // UnsupportedOperationException
//        unmodifiableListFromArray.sort(String::compareTo); // UnsupportedOperationException
//        unmodifiableListFromArray.set(0, "h"); // UnsupportedOperationException


        // В JDK 9 и более поздних версиях:
        List<String> listUnmodifiableStrings = List.of("One", "Two", "Three");
//         listUnmodifiableStrings.add("Four"); // UnsupportedOperationException
//         listUnmodifiableStrings.remove(0); // UnsupportedOperationException
//         listUnmodifiableStrings.clear(); // UnsupportedOperationException
//         listUnmodifiableStrings.sort(String::compareTo); // UnsupportedOperationException
//         listUnmodifiableStrings.set(0, "Five"); // UnsupportedOperationException


//        В JDK 8:
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        System.out.println("stringSet: " + stringSet);

        Set<String> unmodifiableStringSet = Collections.unmodifiableSet(stringSet);
//        unmodifiableStringSet.add("D"); // UnsupportedOperationException
        System.out.println("unmodifiableStringSet: " + unmodifiableStringSet);

        // В JDK 9 и более поздних версиях:
        // Returns an unmodifiable set containing four elements.
        Set<String> exampleSetOf = Set.of("aa", "bb", "cc", "dd");
//        exampleSetOf.add("ee"); // UnsupportedOperationException
        System.out.println("exampleSetOf: " + exampleSetOf);


//        В JDK 8:

        Map<String, Integer> simpleMap = new HashMap<>();
        simpleMap.put("a", 1);
        simpleMap.put("b", 2);
        simpleMap.put("c", 3);

        // Returns an unmodifiable view of the specified map.
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(simpleMap);
        System.out.println(simpleMap == unmodifiableMap); // false
//        unmodifiableMap.replace("a", 11); // UnsupportedOperationException
//        unmodifiableMap.put("yy", 12); // UnsupportedOperationException


        // В JDK 9 и более поздних версиях:

        Map<String, Integer> exampleMap = Map.of(
                "a", 1,
                "b", 2,
                "c", 3);
//        exampleMap.put("d", 4); // UnsupportedOperationException
//        exampleMap.clear(); // UnsupportedOperationException
//        exampleMap.replace("a", 10); // UnsupportedOperationException
        System.out.println(exampleMap);


        // Создавать неизменяемую коллекцию с помощью метода List.of не всегда неудобно.
        List<String> list = new ArrayList<>();
//        list.addAll(getItemsFromSomewhere());
//        list.addAll(getItemsFromElsewhere());
//        list.addAll(getItemsFromYetAnotherPlace());
        List<String> snapshot = List.copyOf(list);

        // Существуют соответствующие статические заводские методы для Set и, Map вызываемые Set.copyOf и Map.copyOf.









        // Создание неизменяемых коллекций из потоков

        Set<String> unmodifiableSet = stringList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(unmodifiableSet);

//        Collectors.toUnmodifiableList()
//        Collectors.toUnmodifiableSet()
//        Collectors.toUnmodifiableMap(keyMapper, valueMapper)
//        Collectors.toUnmodifiableMap(keyMapper, valueMapper, mergeFunction)

        List<String> unmodifiableList = stringList.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(unmodifiableList);
        unmodifiableList.add("new string"); // UnsupportedOperationException
    }
}
