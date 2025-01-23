package com.aston.javabase.multithreading.interrupted;

public class InterruptedExampleClass {

    public static void main(String[] args) throws InterruptedException {
        Robot robot = new Robot();
        Thread clockThread = new Thread(robot);
        clockThread.start();

        Thread.sleep(10000);
        clockThread.interrupt();
    }
}
