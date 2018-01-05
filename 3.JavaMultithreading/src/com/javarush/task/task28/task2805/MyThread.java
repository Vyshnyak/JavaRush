package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static String threadName = currentThread().getName();
    private static ThreadGroup threadGroup = currentThread().getThreadGroup();
    private static final int MAX_PRIORITY = threadGroup.getMaxPriority();
    private static AtomicInteger priority = new AtomicInteger(0);

    public MyThread() {
        this(threadGroup, null, threadName, 0);
    }

    public MyThread(Runnable target) {
        this(threadGroup, target, threadName, 0);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        this(group, target, threadName, 0);
    }

    public MyThread(String name) {
        this(threadGroup, null, name, 0);
    }

    public MyThread(ThreadGroup group, String name) {
        this(group, null, name, 0);
    }

    public MyThread(Runnable target, String name) {
        this(threadGroup, target, name, 0);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        this(group, target, name, 0);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        priority.set(priority.getAndIncrement() % MAX_PRIORITY);
        setPriority(priority.incrementAndGet());
    }

}
