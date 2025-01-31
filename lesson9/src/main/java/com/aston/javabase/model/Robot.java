package com.aston.javabase.model;

import com.aston.javabase.*;
import com.aston.javabase.instruments.Brush;
import com.aston.javabase.instruments.Instrument;
import com.aston.javabase.instruments.Pulverizer;
import com.aston.javabase.instruments.Roller;
import lombok.Builder;

@Builder
public class Robot implements Movable {

    private static final String NAME_OF_SMT = "I am using";
    private static final Integer NO_MAGIC_NUMBER = 12;

    private String name;
    private String number;




    @Override
    public void moveAround() {
        System.out.println("I am moving");
    }

    @Override
    public void moveHands() {
        doSomething(NO_MAGIC_NUMBER);
    }
//
//    @Override
//    public void moveAntenns() {
//    }


    public void doSomething(Integer integer) {
        System.out.println("Do something with " + integer);
    }





    public void paint(Brush brush){
        System.out.println("I am using" + brush);
    }

    public void paint(Pulverizer pulverizer){
        System.out.println("I am using" + pulverizer);
    }

    public void paint(Roller roller){
        System.out.println("I am using" + roller);
    }






    public void paint(Instrument instrument){
        System.out.println("I am painting" + instrument);
    }
}
