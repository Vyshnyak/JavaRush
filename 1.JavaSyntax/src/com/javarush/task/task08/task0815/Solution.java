package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Вишняк", "Максим");
        map.put("Розовна", "Татьяна");
        map.put("Шараев", "Роман");
        map.put("Свечников", "Максим");
        map.put("Козлов", "Роман");
        map.put("Гром", "Илья");
        map.put("Романюк", "Максим");
        map.put("Чубенко", "Ольга");
        map.put("Нестеренко", "Настя");
        map.put("Дурдыев", "Игорь");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();

            if (pair.getValue().equals(name))
                count++;
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();

            if (pair.getKey().equals(lastName))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
