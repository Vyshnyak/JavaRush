package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        boolean isEntered = false;
        String str = null;
        while (!isEntered) {
            try {
                str = reader.readLine();
                isEntered = true;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return str;
    }

    public static int readInt() {
        boolean isNum = false;
        int num = 0;
        while (!isNum) {
            try {
                num = Integer.parseInt(readString());
                isNum = true;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return num;
    }
}
