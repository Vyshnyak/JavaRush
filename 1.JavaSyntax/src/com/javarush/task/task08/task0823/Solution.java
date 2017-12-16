package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();


        //напишите тут ваш код
        StringBuffer stringBuffer = new StringBuffer(s);

        for (int i = 0; i < s.length(); i++)
        {
            if (i == 0 && Character.isLetter(stringBuffer.charAt(i)))
                stringBuffer.setCharAt(i, Character.toUpperCase(stringBuffer.charAt(i)));
            else if (stringBuffer.charAt(i) == ' ' && Character.isLetter(stringBuffer.charAt(i + 1)))
                stringBuffer.setCharAt(i + 1, Character.toUpperCase(stringBuffer.charAt(i + 1)));
        }

        System.out.println(stringBuffer.toString());
    }
}
