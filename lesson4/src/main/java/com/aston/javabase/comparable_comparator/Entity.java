package com.aston.javabase.comparable_comparator;

public class Entity implements Comparable<Entity>{

    private Integer id;
    private final String name;

    public Entity(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Entity entity) {
        return this.name.compareTo(entity.name);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
