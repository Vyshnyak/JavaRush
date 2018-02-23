package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.concurrent.LinkedBlockingQueue;

public class Waiter implements Runnable {
    private LinkedBlockingQueue<Order> cookedOrderQueue;

    public void setCookedOrderQueue(LinkedBlockingQueue<Order> cookedOrderQueue) {
        this.cookedOrderQueue = cookedOrderQueue;
    }

    @Override
    public void run() {
        while (true) {
            if (!cookedOrderQueue.isEmpty()) {
                Order order = cookedOrderQueue.poll();
                ConsoleHelper.writeMessage(order + " was cooked");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
