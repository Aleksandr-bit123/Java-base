package com.aston.javabase.multithreading.synchronizing;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ExampleClass {

    public static void main(String []args){
        Object object = new Object();

        synchronized(object) {
            System.out.println("Hello World");
        }

        Executor executor = new ForkJoinPool();
    }

    // при помощи ключевого слова synchronized текущий поток пытается использовать монитор,
    // ассоциированный с объектом object и "получить лок" или "захватить монитор"
}
