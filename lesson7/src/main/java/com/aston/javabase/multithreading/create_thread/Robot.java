package com.aston.javabase.multithreading.create_thread;

public class Robot implements Runnable{

    @Override
    public void run() {
        System.out.println("Robot running");
    }
}
