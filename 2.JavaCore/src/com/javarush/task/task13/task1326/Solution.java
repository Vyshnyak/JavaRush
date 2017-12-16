package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filereader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        ArrayList<Integer> list = new ArrayList<Integer>();

        // read number from file and write it into array
        while (filereader.ready())
        {
            String data = filereader.readLine();

            if (Integer.parseInt(data) % 2 == 0)
                list.add(Integer.parseInt(data));
        }

        // sort the numbers in ascending order
        for (int i = 0; i < list.size(); i++) {
            int min = i;

            for (int j = i + 1; j < list.size(); j++)
                min = list.get(j) < list.get(min) ? j : min;

            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }

        // output numbers on the screen
        for (Integer num : list) {
            System.out.println(num);
        }

        filereader.close();
    }
}
