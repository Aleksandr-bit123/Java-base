package com.aston.javabase.multithreading.create_thread;

public class CreateThreadClass {

    public static void main(String[] args) {

        Robot robot = new Robot();
        Thread childThread = new Thread(robot); // Главная нить создает дочернюю нить

        childThread.start();// Затем запускает ее


        try {
            childThread.join(); // И ждет ее завершения
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
