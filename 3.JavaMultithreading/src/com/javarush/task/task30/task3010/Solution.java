package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String number = args[0];
            int minRegex = 0;
            if (number.matches("[A-Za-z0-9]+")) {
                for (int i = 2; i <= 36; i++) {
                    try {
                        new BigInteger(number, i);
                        if (minRegex == 0) {
                            minRegex = i;
                        }
                    } catch (NumberFormatException e) {
                    /*NOP*/
                    }
                }
            }
            if (minRegex == 0) {
                System.out.println("incorrect");
            } else {
                System.out.println(minRegex);
            }
        } catch (Exception e) {
            /*NOP*/
        }
    }
}