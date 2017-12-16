package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());

        int longest = 0;
        int shortest = 0;

        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i).length() > list.get(longest).length())
                longest = i;
            else if (list.get(i).length() < list.get(shortest).length())
                shortest = i;
        }

        if (longest < shortest)
            System.out.println(list.get(longest));
        else
            System.out.println(list.get(shortest));
    }
}
