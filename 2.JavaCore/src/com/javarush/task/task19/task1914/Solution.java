package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream newPrintStream = new PrintStream(outputStream);
        System.setOut(newPrintStream);

        testString.printSomething();

        String[] exprMembers = outputStream.toString().split(" ");

        solveExpression(exprMembers);

        System.setOut(oldPrintStream);
        System.out.println(String.format("%s %s %s %s %s", exprMembers[0], exprMembers[1], exprMembers[2], exprMembers[3], exprMembers[4]));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static void solveExpression(String[] exprMembers) {
        int result = 0;

        switch (exprMembers[1]) {
            case "+":
                result = Integer.parseInt(exprMembers[0]) + Integer.parseInt(exprMembers[2]);
                break;
            case "-":
                result = Integer.parseInt(exprMembers[0]) - Integer.parseInt(exprMembers[2]);
                break;
            case "*":
                result = Integer.parseInt(exprMembers[0]) * Integer.parseInt(exprMembers[2]);
                break;
        }

        exprMembers[4] = String.valueOf(result);
    }
}

