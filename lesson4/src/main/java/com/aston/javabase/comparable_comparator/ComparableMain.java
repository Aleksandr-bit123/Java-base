package com.aston.javabase.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain {

    public static void main(String[] args) {
        Entity firstEntity = new Entity("First Entity");
        Entity secondEntity = new Entity("Second Entity");
        Entity anEntity = new Entity("An Entity");

        List<Entity> entities = new ArrayList<>();
        entities.add(firstEntity);
        entities.add(secondEntity);
        entities.add(anEntity);

        Collections.sort(entities);
        System.out.println(entities);
    }
}
