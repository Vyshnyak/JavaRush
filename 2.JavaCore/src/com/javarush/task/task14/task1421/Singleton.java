package com.javarush.task.task14.task1421;

/**
 * Created by Максим on 12.06.2017.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }
}
