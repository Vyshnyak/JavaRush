package com.javarush.task.task17.task1711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static DateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy");
    private static DateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++)
                        addPerson(args[i], args[++i], args[++i]);
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++)
                        updateData(Integer.parseInt(args[i]), args[++i], args[++i], args[++i]);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++)
                        removePerson(Integer.parseInt(args[i]));
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++)
                        printData(Integer.parseInt(args[i]));
                }
                break;
        }
    }

    public synchronized static void addPerson(String name, String sex, String birthDate) throws ParseException {

        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, dateFormatInput.parse(birthDate)));
            System.out.println(allPeople.size() - 1);
        }
        else if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, dateFormatInput.parse(birthDate)));
            System.out.println(allPeople.size() - 1);
        }
    }

    public synchronized static void updateData(int id, String name, String sex, String birthDate) throws ParseException {
        Person person = allPeople.get(id);

        person.setName(name);

        if (sex.equals("м"))
            person.setSex(Sex.MALE);
        else if (sex.equals("ж"))
            person.setSex(Sex.FEMALE);

        person.setBirthDay(dateFormatInput.parse(birthDate));
    }

    public synchronized static void removePerson(int id) {
        Person person = allPeople.get(id);

        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    public synchronized static void printData(int id) {

        Person person = allPeople.get(id);
        String name = person.getName();
        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        Date birthdate = person.getBirthDay();

        System.out.println(name + " " + sex + " " + dateFormatOutput.format(birthdate));
    }
}
