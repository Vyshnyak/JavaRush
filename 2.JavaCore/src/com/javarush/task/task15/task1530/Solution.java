package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        DrinkMaker[] drinkMakers = {new LatteMaker(), new TeaMaker()};

        for (DrinkMaker drink : drinkMakers)
            drink.makeDrink();
    }
}
