package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        Dish[] allDishes = Dish.values();
        List<Dish> orderedDishes = new ArrayList<>();
        Random random = new Random();
        int numberOfDishes = random.nextInt(allDishes.length + 1);
        while (numberOfDishes > 0) {
            int dishIndex = random.nextInt(allDishes.length);
            orderedDishes.add(allDishes[dishIndex]);
            numberOfDishes--;
        }
        dishes = orderedDishes;
    }
}
