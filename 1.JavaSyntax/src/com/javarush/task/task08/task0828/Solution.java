package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        SimpleDateFormat dateformat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        HashMap<String, Integer> map = new HashMap<String,Integer>();

        for (int i = 0; i < 12; i++)
            map.put(dateformat.format(new Date(2016, i,1)), i + 1);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String month = reader.readLine();
        System.out.println(month + " is" + " " + map.get(month) + " month");
    }
}
