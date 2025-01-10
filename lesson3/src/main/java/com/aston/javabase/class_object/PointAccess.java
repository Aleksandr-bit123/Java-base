package com.aston.javabase.class_object;

public class PointAccess {

    public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException {

        Dog dog = new Dog("MyDogName");
        Dog dog2 = dog;

        boolean equals = dog2.equals(dog);

        Object clone = dog.clone();

//        System.out.println(dog.toString());
        Class<Dog> dogClass = Dog.class;
        System.out.println(dogClass.getName());
        System.out.println(dogClass.getSimpleName());
        System.out.println(dogClass.getClassLoader());
    }
}
