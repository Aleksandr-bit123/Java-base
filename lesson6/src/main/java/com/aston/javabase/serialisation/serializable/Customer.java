package com.aston.javabase.serialisation.serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter
@ToString
public class Customer implements Serializable {

    private int age;
    private String name;
    private transient String transientSecretCode;
}


//public String getName() {
//    return name;
//}
//
//public int getAge() {
//    return age;
//}
//
//public void setName(String name) {
//    this.name = name;
//}
//
//public void setAge(int age) {
//    this.age = age;
//}
//
//@Override
//public String toString() {
//    return "Customer{" +
//            "name='" + name + '\'' +
//            ", age=" + age +
//            '}';
//}