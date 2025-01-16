package com.aston.javabase.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamsMain {

    public static void main(String[] args) {
        // Из коллекции:
        Stream<String> fromCollection = Arrays.asList("x", "y", "z").stream();
        
        // Из набора значений:
        Stream<String> fromValues = Stream.of("x", "y", "z");

        // Из массива:
        Stream<String> fromArray = Arrays.stream(new String[]{"x", "y", "z"});

        // Из файла (каждая строка в файле будет отдельным элементом в стриме):
        try (Stream<String> fromFile = Files.lines(Paths.get("input.txt"))) {
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    
        // Из строки:
        IntStream fromString = "0123456789".chars();
    
        // С помощью Stream.builder():
        Stream fromBuilder = Stream.builder()
                .add("z")
                .build();

        // С помощью Stream.iterate() (бесконечный):
        Stream<Integer> fromIterate = Stream.iterate(1, n -> n + 1);

        // С помощью Stream.generate() (бесконечный):
        Stream<String> fromGenerate = Stream.generate(() -> "0");

    }
}
