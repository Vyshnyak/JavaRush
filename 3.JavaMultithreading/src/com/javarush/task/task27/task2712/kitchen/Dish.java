package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder listOfDishes = new StringBuilder();
        for (Dish dish : Dish.values()) {
            listOfDishes.append(dish);
            listOfDishes.append(", ");
        }
        int listSize = listOfDishes.length();
        return listOfDishes.delete(listSize - 2, listSize - 1).toString();
    }
}
