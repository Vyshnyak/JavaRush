package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
            list.add(Integer.parseInt(reader.readLine()));

        int series = 1;
        int longestSeries = 1;

        for (int i = 1; i < list.size(); i++)
        {
                if (list.get(i).equals(list.get(i - 1)))
                {
                    series++;
                    if (series > longestSeries)
                        longestSeries = series;
                }
                else
                    series = 1;
        }

        System.out.println(longestSeries);
    }
}