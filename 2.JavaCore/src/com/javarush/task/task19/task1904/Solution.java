package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScanner personScanner = new PersonScannerAdapter(
                new Scanner(new File("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1904\\test")));

        System.out.println(personScanner.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] personData = fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");

            return new Person(personData[1], personData[2], personData[0], simpleDateFormat.parse(personData[3]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
