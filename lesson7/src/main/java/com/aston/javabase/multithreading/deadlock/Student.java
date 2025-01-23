package com.aston.javabase.multithreading.deadlock;

import java.util.ArrayList;

public class Student {

    private volatile Integer integer;

    private ArrayList friends = new ArrayList();

    // Допустим, первая нить вызвала метод getFriends,
    // тогда она сначала захватит мютекс объекта this,
    // а затем мютекс объекта friends.
    public synchronized ArrayList getFriends()
    {
        synchronized(friends)
        {
            return new ArrayList(friends);
        }
    }

    public synchronized int getFriendsCount()
    {
        return friends.size();
    }

    // Вторая нить при этом вызвала метод addFriend,
    // она сначала захватывает мютекс объекта friends,
    // а затем мютекс объекта this (при вызове getFriendsCount).
    public int addFriend(Student student)
    {
        synchronized(friends)
        {
            friends.add(student);
            return getFriendsCount();
        }
    }
}
// возникнет ситуация, когда первая нить успеет захватить только один мютекс,
// а вторая нить в это время захватит второй. Они так и будут висеть вечно в ожидании,
// что кто-то из них первым освободит мютекс.