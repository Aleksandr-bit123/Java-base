package com.aston.javabase.serialisation.externalizable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExternalizableMain {

    public static void main(String[] args) {

        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\anduser\\Desktop\\save_order2.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            Customer2 customer = new Customer2();
            customer.setAge(34);
            customer.setName("Jack");
            customer.setSecretCode("secretCode");

            Order2 order = new Order2();
            order.setOrderId(555);
            order.setCustomer(customer);

            objectOutputStream.writeObject(order);
            objectOutputStream.flush();

        } catch (IOException e) {
            System.out.println("Логируем исключение при попытке сериализовать объект заказа");
            throw new RuntimeException(e);
        }
    }
}
