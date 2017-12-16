package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<String, Cat>();

        map.put("Кот1", new Cat("Макс"));
        map.put("Кот2", new Cat("Факс"));
        map.put("Кот3", new Cat("Бакс"));
        map.put("Кот4", new Cat("Сакс"));
        map.put("Кот5", new Cat("Тракс"));
        map.put("Кот6", new Cat("Гакс"));
        map.put("Кот7", new Cat("Вакс"));
        map.put("Кот8", new Cat("Накс"));
        map.put("Кот9", new Cat("Дакс"));
        map.put("Кот10", new Cat("Пакс"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        return new HashSet<Cat>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
