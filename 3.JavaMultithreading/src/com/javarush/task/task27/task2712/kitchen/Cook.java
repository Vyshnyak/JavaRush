package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook implements Runnable {
    protected String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;
    private LinkedBlockingQueue<Order> cookedOrderQueue;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (!queue.isEmpty() && !isBusy()) {
                startCookingOrder(queue.poll());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void setCookedOrderQueue(LinkedBlockingQueue<Order> cookedOrderQueue) {
        this.cookedOrderQueue = cookedOrderQueue;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        int totalCookingTime = order.getTotalCookingTime();
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order.toString(), totalCookingTime));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, totalCookingTime * 60, order.getDishes()));
        try {
            Thread.sleep(totalCookingTime * 10);
        } catch (InterruptedException e) {
            /*NOP*/
        }
        cookedOrderQueue.offer(order);
        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
