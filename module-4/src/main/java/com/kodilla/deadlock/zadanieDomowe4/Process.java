package com.kodilla.deadlock.zadanieDomowe4;

public class Process{
    private static final Object lock = new Object();

    public void run(String processName, Resource resourceFrom, Resource resourceTo) {
        try {
            Thread.sleep(50);
            synchronized (lock) {
                resourceFrom.printName();
                System.out.println(processName + " part 1");
                Thread.sleep(50);
                resourceTo.printName();
                System.out.println(processName + " part 2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
