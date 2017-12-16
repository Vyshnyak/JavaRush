package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 1; i < 21; i++)
            set.add(i);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();)
        {
            int num = iterator.next();
            if (num > 10)
                iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
