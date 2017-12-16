package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        int temp;

        while (num > 0)
        {
           temp = (num % 10) % 2 == 0 ? Solution.even++ : Solution.odd++;
           num /= 10;
        }

        System.out.println("Even: " + Solution.even + " Odd: " + Solution.odd);
    }
}
