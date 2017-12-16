package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args[0].equals("-c"))
            addPerson(args[1], args[2], args[3]);
        else if (args[0].equals("-u"))
            updateData(allPeople.get(Integer.parseInt(args[1])), args[2], args[3], args[4]);
        else if (args[0].equals("-d"))
            deletePerson(allPeople.get(Integer.parseInt(args[1])));
        else if (args[0].equals("-i"))
            printInfo(allPeople.get(Integer.parseInt(args[1])));
    }

    public static void addPerson(String name, String sex, String birthDate) {
        if (sex.equals("м")) {
            try {
                allPeople.add(Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy").parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(allPeople.size() - 1);
        }
        else if (sex.equals("ж")) {
            try {
                allPeople.add(Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy").parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(allPeople.size() - 1);
        }
    }

    public static void updateData(Person person, String name, String sex, String birthDate) {
        person.setName(name);
        person.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
        try {
            person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(birthDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson(Person person) {
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    public static void printInfo(Person person) {
        String name = person.getName();
        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        Date birthDate = person.getBirthDay();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(name + " " + sex + " " + sdf.format(birthDate));
    }
}
