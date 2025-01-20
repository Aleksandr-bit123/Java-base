package com.aston.javabase.serialisation.externalizable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializableMain {

    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\anduser\\Desktop\\save_order2.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Order2 order = (Order2) objectInputStream.readObject();

            System.out.println(order);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Логируем исключение при попытке десериализовать объект заказа");
            throw new RuntimeException(e);
        }
    }
}
