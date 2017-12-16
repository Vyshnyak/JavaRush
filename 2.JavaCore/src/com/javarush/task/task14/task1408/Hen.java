package com.javarush.task.task14.task1408;

/**
 * Created by Максим on 09.06.2017.
 */
abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    String getDescription() {
        return "Я - курица.";
    }
}
