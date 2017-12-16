package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(arrayOutputStream);

        System.setOut(outputStream);

        testString.printSomething();

        String changedString = arrayOutputStream.toString().toUpperCase();
        System.setOut(consoleStream);

        System.out.println(changedString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
