package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        copyFromFileToList(fileReader);

        fileReader.close();
    }

    public static void copyFromFileToList(BufferedReader fileReader) throws IOException, ParseException {
        String data;
        while ((data = fileReader.readLine()) != null) {
            String[] name = data.split("(\\s\\d+){3}");
            String[] birthday = data.split("([А-Яа-я]+\\s){1,3}");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            PEOPLE.add(new Person(name[0], dateFormat.parse(birthday[1])));
        }
    }
}
