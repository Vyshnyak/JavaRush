package com.javarush.task.task08.task0817;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        // мое решение (время - 0)
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            int sizeBefore = map.size();
            removeItemFromMapByValue(map, pair.getValue());
            if (map.size() == sizeBefore - 1)
                map.put(pair.getKey(), pair.getValue());
        }

        //чужое решение №1 (время - 1)
        /*Date timeBefore = new Date();
           HashMap<String, String> copy = new HashMap<String, String>(map);
           for (Map.Entry<String, String> pair : copy.entrySet()){
               int count = 0;
               for (Map.Entry pair2 : copy.entrySet()){
                   if (pair2.getValue().equals(pair.getValue())){
                       count++;
                       if (count > 1)
                           removeItemFromMapByValue(map, pair.getValue());
                   }
               }
           }

        // чужое решение №2 (время - неизвестно)
        /*HashMap<String, String> copy = new HashMap<String, String>(map);
        for (String value : copy.values())
            if (Collections.frequency(copy.values(), value) > 1)
                removeItemFromMapByValue(map, value);*/
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }
}
