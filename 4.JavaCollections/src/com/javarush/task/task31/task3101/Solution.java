package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File directory = new File(args[0]);
        List<File> files = getAllFiles(directory);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public static List<File> getAllFiles(File directory) {
        List<File> files = new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            recFun(files, directory);
        }
        return files;
    }

    public static void recFun(List<File> files, File directory) {
        if (directory.listFiles().length == 0) {
            return;
        }
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                recFun(files, file);
            } else {
                files.add(file);
            }
        }
    }
}
