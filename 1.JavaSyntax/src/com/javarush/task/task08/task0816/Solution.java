package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Carry", new Date("JULY 1 1980"));
        map.put("Depp", new Date("JANUARY 1 1980"));
        map.put("Damon", new Date("JUNE 1 1980"));
        map.put("Stone", new Date("AUGUST 1 1980"));
        map.put("Pattison", new Date("SEPTEMBER 1 1980"));
        map.put("Zdorovetskiy", new Date("OCTOBER 1 1980"));
        map.put("Ivanguy", new Date("FEBRUARY 1 1980"));
        map.put("Roberts", new Date("DECEMBER 1 1980"));
        map.put("Harington", new Date("JUNE 1 1980"));

        return  map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            int month = pair.getValue().getMonth();
            if (month == 5 || month == 6 || month == 7)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}
