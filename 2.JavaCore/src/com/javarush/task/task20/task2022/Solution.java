package com.javarush.task.task20.task2022;

import java.io.*;
import java.lang.reflect.Field;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException, NoSuchFieldException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution1 = new Solution("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\test");
        solution1.writeObject("Some text...");

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\test2");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution1);

        FileInputStream fileInputStream = new FileInputStream("D:\\Programming\\JavaRush\\ProjectsIDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\test2");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        Solution solution2 = (Solution) inputStream.readObject();
        solution2.writeObject("Some text2...");
    }
}
