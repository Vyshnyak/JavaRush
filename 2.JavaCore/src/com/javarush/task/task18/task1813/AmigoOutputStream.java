package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    protected FileOutputStream decoratedStream;

    public AmigoOutputStream(FileOutputStream decoratedStream) throws FileNotFoundException {
        super(fileName);
        this.decoratedStream = decoratedStream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void close() throws IOException {
        flush();
        byte[] bytes = "JavaRush © All rights reserved.".getBytes();
        decoratedStream.write(bytes);
        decoratedStream.close();
    }

    @Override
    public void write(int b) throws IOException {
        decoratedStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        decoratedStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        decoratedStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        decoratedStream.flush();
    }
}
