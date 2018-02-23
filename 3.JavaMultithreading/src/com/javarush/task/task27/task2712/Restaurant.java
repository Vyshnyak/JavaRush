package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private final static LinkedBlockingQueue<Order> cookedOrderQueue = new LinkedBlockingQueue<>();
    private final static int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) throws InterruptedException {
        DirectorTablet directorTablet = new DirectorTablet();
        Cook firstCook = new Cook("Amigo");
        firstCook.setQueue(orderQueue);
        firstCook.setCookedOrderQueue(cookedOrderQueue);
        new Thread(firstCook).start();
        Cook secondCook = new Cook("Rodrigo");
        secondCook.setQueue(orderQueue);
        secondCook.setCookedOrderQueue(cookedOrderQueue);
        new Thread(secondCook).start();
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.setQueue(orderQueue);
        }
        Waiter waiter = new Waiter();
        waiter.setCookedOrderQueue(cookedOrderQueue);
        new Thread(waiter).start();
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}