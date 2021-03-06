package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderedDishes = new ArrayList<>();
        System.out.println(Dish.allDishesToString());
        writeMessage("Выберите название блюда:");
        String dish;
        while (!(dish = readString()).equals("exit")) {
            try {
                orderedDishes.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет в списке.");
            }
        }
        return orderedDishes;
    }
}
