package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream streamStorage = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream newOutputStream = new PrintStream(outputStream);
        System.setOut(newOutputStream);

        testString.printSomething();

        String modString = outputStream.toString().replace("te", "??");
        System.setOut(streamStorage);

        System.out.println(modString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
