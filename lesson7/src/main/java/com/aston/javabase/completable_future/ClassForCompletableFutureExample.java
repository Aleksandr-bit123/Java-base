package com.aston.javabase.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ClassForCompletableFutureExample {

    public static void main(String[] args) {

    }

    // Задача пользователя: печатать тот или иной заказ клиента.
    // Операция выполняется асинхронно и не возвращает результат.
    // Другими словами, он берет объект Runnable и возвращает CompietabieFuture<void>
    public static void printorder() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cfPrintOrder = CompletableFuture.runAsync(() -> {

            System.out.println("Заказ печатается: " + Thread.currentThread().getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        cfPrintOrder.get(); // блокировать до тех пор, пока заказ не будет напечатан
        System.out.println("Заказ клиента напечатан...");
    }

    // Задача пользователя: получить сводку заказа того или иного клиента.
    // На этот раз асинхронная операция должна возвращать результат, и поэтому метод runAsync о бесполезен.
    // Эта операция подходит для метода supplyAsync. Он берет поставщика suppiier<T> и возвращает compietabieFuture<T>.
    // T — это тип результата, получаемого от данного поставщика посредством метода get().
    public static void fetchOrderSummary() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cfOrderSummary = CompletableFuture.supplyAsync(() -> {

            System.out.println("Получить сводку заказа: " + Thread.currentThread().getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Сводка заказа #93443";
        });

        // ждать до тех пор, пока не появится сводка; эта операция блокирует
        String summary = cfOrderSummary.get();
        System.out.println("Сводка заказа: " + summary + "\n");
    }
}
