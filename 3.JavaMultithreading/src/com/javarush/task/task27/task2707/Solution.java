package com.javarush.task.task27.task2707;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/*
Определяем порядок захвата монитора
*/
public class Solution {

    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });

        synchronized (o2) {
            thread1.start();
            while (thread1.getState() != Thread.State.BLOCKED);
        }
        synchronized (o1) {
            thread1.join(100);
            if (thread1.getState() == Thread.State.TERMINATED) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
