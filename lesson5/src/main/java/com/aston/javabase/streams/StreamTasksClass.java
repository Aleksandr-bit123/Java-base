package com.aston.javabase.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasksClass {

    private static List<Order> orders = Arrays.asList(
            new Order("A123", Arrays.asList("Laptop", "Mouse", "Keyboard"), 1500.0),
            new Order("B456", Arrays.asList("Smartphone", "Headphones"), 800.0),
            new Order("C789", Arrays.asList("Tablet", "Charger"), 600.0)
    );

    @Data
    @AllArgsConstructor
    public static class Order {

        private String orderId;
        private List<String> items;
        private Double totalPrice;
    }

    public static void main(String[] args) {


        System.out.println(getCommonPrice(orders)); // 2300.0

    }










    // Задача 1
    // расчитать общую стоимость дорогих заказов > 700
    public static Double getCommonPrice(List<Order> list) {
        return list.stream()
                .filter(order -> order.getTotalPrice() > 700)
                .mapToDouble(Order::getTotalPrice)
                .sum();
//                .collect(Collectors.summingDouble(Order::getTotalPrice));
    }







    // Задача 2
    //    Получить список наименований товаров, которые находятся в заказе с суммой менее 1000 и имя которых начинается на "S"
    public static List<String> checkOrders(List<Order> list) {
        return list.stream()
                .filter(order -> order.getTotalPrice() < 1000)
                .map(Order::getItems)
                .flatMap(Collection::stream)
                .filter(it -> it.startsWith("S"))
                .collect(Collectors.toList());
    }

    //    Метод повторяет предыдущий
    //    Получить список наименований товаров, имя корорых начинается на "S", при условии,
    //    что они входят в заказ, стоимостью менее 1000
    public static List<String> checkOrders2(List<Order> list) {
        return list.stream()
                .filter(order -> order.getTotalPrice() < 1000)
                .flatMap(order -> order.getItems().stream())
                .filter(it -> it.startsWith("S"))
                .collect(Collectors.toList());
    }










    // Задача 3
    public static void someMethod() {
        final List<String> list = List.of("one", "two", "three");

        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
                .forEach(x -> System.out.println("forEach: " + x));
//        filter: one
//        map: one
//        forEach: ONE
//        filter: two
//        map: two
//        forEach: TWO
//        filter: three
    }








    // Задача 4
    public static void doSmth() {
        final List<String> list = List.of("one", "two", "three");

        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
                .sorted()
                .forEach(x -> System.out.println("forEach: " + x));
    }
//    filter: one
//    map: one
//    filter: two
//    map: two
//    filter: three
//    forEach: ONE
//    forEach: TWO

//    Операции без состояния (stateless), такие как map() и filter(),
//    обрабатывают каждый элемент потока независимо от других.
//    Они не требуют информации о других элементах для своей работы,
//    что делает их идеально подходящими для параллельной обработки.
//
//    С другой стороны, операции, сохраняющие состояние (stateful),
//    такие как sorted(), distinct() или limit(),
//    требуют знания о других элементах для своей работы.
//    Это означает, что им приходится учитывать все (или часть) элементы в потоке перед выдачей какого-либо результата.
//
//    Если ваш пайплайн содержит только операции без состояния,
//    то он может быть обработан "в один проход".
//    Если же он содержит операции с состоянием,
//    то пайплайн разбивается на секции, где каждая секция заканчивается операцией с состоянием.











    // Задача 5
    // Как можно вывести на экран уникальные квадраты чисел?
    public static void doSmth4() {

        Stream.of(1, 2, 3, 2, 1)
                .distinct()
                .map(s -> s * s)
                .forEach(System.out::println);
    } // 1 4 9











    // Задача 6
    // Что будет выведено в консоль?
    public static void doSmth5() {

        Stream.of(1, 4, 3)
                .peek(System.out::println)
                .sorted()
                .peek(System.out::println)
                .anyMatch(element -> element == 3); // 1 4 3  1 3

//        Stream.of(1, 4, 3)
//                .peek(System.out::println)
//                .distinct()
//                .peek(System.out::println)
//                .anyMatch(element -> element == 3); // 1 1 4 4 3 3
    }











    // Задача 7
    // Преобразовать List<List<String>> strings
    // в <List<String>
    public static List<String> transformData(List<List<String>> strings) {

        return strings.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }















    // Задача 8
    // Есть список целых чисел. int[] arr = {10, 15, 23, 10, 15, 10, 66, 10, 66, 15}
    // Вывести пары для чисел, которые встречаются более 2-х раз.
    // 10 -> 4
    // 15 -> 3
    public static void findPairOfNumbers(int[] arr) {
        Arrays.stream(arr)
                .boxed()
                .collect( Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 2)
                .forEach( entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }





    // Задача 9
    // Как отработает метод
    public static void getElementStartsWith(){
        Stream<String> distinct = Stream.of("A", "B", "C", "D", "E").distinct();

        distinct.anyMatch(e -> {
            System.out.println(e);
            return e.startsWith("C");
        });
    } // A B C









    // Задача 10
    // Дан список Arrays.asList(1, 2, 3, 2, 2, 3)
    // Вывести строку, состоящую из уникальных элементов списка
    public static String getUniqueElements(List<Integer> list) {
        return list.stream()
                .distinct()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
