package com.aston.javabase.functional_interface;

import com.aston.javabase.comporator.Dog;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaceMain {

    public static void main(String[] args) {

        Function<String, Integer> function = new Function<>() {

            @Override
            public Integer apply(String str) {
                return str.length();
            }
        };

        Function<String, Integer> stringToInteger =  s -> s.length();
        System.out.println(stringToInteger.apply("123")); // 3





        UnaryOperator<Integer> unaryOperator = new UnaryOperator<>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        UnaryOperator<Integer> operator = x -> x * x;
        System.out.println(operator.apply(5)); // 25






        Predicate predicate = new Predicate() {

            @Override
            public boolean test(Object o) {
                return false;
            }
        };

        Predicate<String> stringPredicate = s -> s.length() > 0;
        System.out.println(stringPredicate.test("foo")); // true
        System.out.println(stringPredicate.negate().test("foo")); // false





        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
            }
        };

        List<Dog> dogs = Arrays.asList(
                new Dog("Dog", 3),
                new Dog("Dog", 2),
                new Dog("Dog", 1),
                new Dog("Asole", 2),
                new Dog("Amur", 1)
        );

        dogs.forEach(dog -> System.out.println(dog.getName()));
        dogs.forEach(System.out::println);






        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };

        Supplier<LocalDateTime> now = () -> LocalDateTime.now();
        System.out.println(now.get()); // date and time now
    }
}
