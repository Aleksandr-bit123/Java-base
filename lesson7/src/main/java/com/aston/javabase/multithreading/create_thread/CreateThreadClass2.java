package com.aston.javabase.multithreading.create_thread;

public class CreateThreadClass2 {

    public static void main(String[] args) {

        Robot2 robot2 = new Robot2();
        robot2.setPriority(Thread. MAX_PRIORITY);
        robot2.start();


        Thread.yield();
        // Подсказка планировщику о том, что
        // поток готов отказаться от текущего использования процессора.
        // Планировщик может проигнорировать эту подсказку.
    }
}
