package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static
    {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());

    }

    public static void main(String[] args) {
        threads.get(4).start();
    }

    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true){}
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadFour extends Thread implements Message {

        volatile boolean isInterrupted = false;
        @Override
        public void showWarning() {
            isInterrupted = true;
        }

        @Override
        public void run() {
            while (!isInterrupted) {

            }
        }
    }

    public static class ThreadFive extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            try {
                while (true) {
                    sum += Integer.parseInt(reader.readLine());
                }
            }
            catch (NumberFormatException e) {

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }
}