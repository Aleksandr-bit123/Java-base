package com.aston.javabase.multithreading.interrupted;

public class Robot implements Runnable {

    @Override
    public void run() {
        Thread current = Thread.currentThread();

        while (!current.isInterrupted()) {
            try {
                Thread.sleep(1000);
                // в методе sleep, есть автоматическая проверка переменной isInterrupted.
                // Если нить вызовет метод sleep, то этот метод сначала проверит,
                // а не установлена ли для текущей (вызвавшей его нити) переменная isInterrupted в true.
                // И если установлена, то метод не будет спать, а выкинет исключение InterruptedException.
            } catch (InterruptedException e) {
                e.printStackTrace();
                current.interrupt(); // native inform VM of interrupt
            }
            System.out.println("Working");
        }
    }
}
