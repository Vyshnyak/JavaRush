package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        AtomicInteger counter = new AtomicInteger(0);
        while (true) {
            map.putIfAbsent(String.valueOf(counter.incrementAndGet()), String.format("Some text for %d", counter.get()));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(String.format("%s thread was terminated", Thread.currentThread().getName()));
                break;
            }
        }
    }
}
