package com.aston.javabase.serialisation.serializable;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeserializableMain {

    public static void main(String[] args) {

//        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\anduser\\Desktop\\save_order.ser");
        try (InputStream inputStream = Files.newInputStream(Path.of("C:\\Users\\anduser\\Desktop\\save_order.ser"));
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Order order = (Order) objectInputStream.readObject();

            System.out.println(order);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Логируем исключение при попытке десериализовать объект заказа");
            throw new RuntimeException(e);
        }
    }
}
