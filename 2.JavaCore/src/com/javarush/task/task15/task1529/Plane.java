package com.javarush.task.task15.task1529;

/**
 * Created by Максим on 20.06.2017.
 */
public class Plane implements Flyable {

    private int passengers;

    public Plane(int n) {
        this.passengers = n;
    }

    @Override
    public void fly() {

    }
}
