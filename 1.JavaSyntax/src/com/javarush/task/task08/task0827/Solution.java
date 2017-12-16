package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date date1 = new Date(date);
        Date date2 = new Date(date1.getYear(), 0, 0);

        return (int)((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000)) % 2 == 0 ? false : true;
    }
}
