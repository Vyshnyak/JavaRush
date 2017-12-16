package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream oldStream = System.out;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        writeToFile(fileName,oldStream);

        reader.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }

    public static void writeToFile(String fileName, PrintStream oldStream) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

            PrintStream newStream = new PrintStream(arrayOutputStream);
            System.setOut(newStream);

            testString.printSomething();

            fileOutputStream.write(arrayOutputStream.toByteArray());

            System.setOut(oldStream);
            System.out.println(arrayOutputStream.toString());
        }
        catch (FileNotFoundException e) {
            /*NOP*/
        }
        catch (IOException e) {
            /*NOP*/
        }
    }
}

