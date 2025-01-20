package com.aston.javabase.serialisation.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializableMain {
    
    public static void main(String[] args) {

        // Начиная с Java 5 классы FileInputStream и FileOutputStream стали считаться устаревшими.
        // try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\anduser\\Desktop\\save_order.ser");
        try (OutputStream outputStream = Files.newOutputStream(Path.of("C:\\Users\\anduser\\Desktop\\save_order.ser"));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {

            Customer customer = new Customer();
            customer.setAge(28);
            customer.setName("Jack");
            customer.setTransientSecretCode("secretCode");

            Order order = new Order();
            order.setOrderId(1);
            order.setCustomer(customer);

            objectOutputStream.writeObject(order);
            objectOutputStream.flush();

        } catch (IOException e) {
            System.out.println("Логируем исключение при попытке сериализовать объект заказа");
            throw new RuntimeException(e);
        }
    }
}
