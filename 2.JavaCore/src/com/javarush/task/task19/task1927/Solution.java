package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        printTextWithPPC();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static void printTextWithPPC() {
        PrintStream oldStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);

        testString.printSomething();

        System.setOut(oldStream);

        String[] words = outputStream.toString().split("\\n");

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            if (i % 2 == 1)
                System.out.println("JavaRush - курсы Java онлайн");
        }
    }
}
