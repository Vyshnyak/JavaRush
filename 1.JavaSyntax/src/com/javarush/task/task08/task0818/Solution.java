package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("Вишняк", 2000);
        map.put("Розовна", 300);
        map.put("Шараев", 250);
        map.put("Свечников", 760);
        map.put("Козлов", 150);
        map.put("Гром", 1000);
        map.put("Романюк", 600);
        map.put("Чубенко", 450);
        map.put("Нестеренко", 800);
        map.put("Дурдыев", 1500);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);

        for (Map.Entry<String, Integer> pair : copy.entrySet())
        {
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}