package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        StringBuffer string = new StringBuffer(s);

        for (int i = 0; i < 40; i++)
        {
            System.out.println(string);
            string.deleteCharAt(0);
        }
    }

}

