package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < alphabet.size(); i++)
        {
            int count = 0;
            for (int j = 0; j < list.size(); j++)
            {
                for (int c = 0; c < list.get(j).length(); c++)
                {
                    if (list.get(j).charAt(c) == alphabet.get(i))
                        count++;
                }
            }
            numbers.add(count);
        }

        for (int i = 0; i < alphabet.size(); i++)
            System.out.println(alphabet.get(i) + " " + numbers.get(i));

        //solution from another person
        /*HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

        for (char ch: alphabet)
            counter.put(ch, 0);

        for (String s: list) {
            for (char ch : s.toCharArray())
                counter.put(ch, (counter.get(ch) + 1));
        }

        for (char ch : alphabet)
            System.out.println(ch + " " + counter.get(ch));*/
    }

}
