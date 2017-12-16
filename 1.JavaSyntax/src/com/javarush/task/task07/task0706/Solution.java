package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[15];

        int residentsNotEven = 0;
        int residentsEven = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(reader.readLine());

            if (i % 2 == 0)
                residentsEven += numbers[i];
            else
                residentsNotEven += numbers[i];
        }

        if (residentsNotEven > residentsEven)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
