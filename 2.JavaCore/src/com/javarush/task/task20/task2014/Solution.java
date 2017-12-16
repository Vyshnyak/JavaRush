package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\test"));
            ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\test")))
        {
            Solution savedObject = new Solution(4);
            outputStream.writeObject(savedObject);

            Solution loadedObject = (Solution) inputStream.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
        }
        catch (ClassNotFoundException e) {
            /*NOP*/
        }
        catch (IOException e) {
            /*NOP*/
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
