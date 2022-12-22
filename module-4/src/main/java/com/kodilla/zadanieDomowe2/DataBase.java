package com.kodilla.zadanieDomowe2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataBase {
    private final Queue<Customer> customers = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition dbNotEmpty = lock.newCondition();
    private final Condition dbNotFull = lock.newCondition();
    private static final int CAPACITY = 15;

    public void select() throws InterruptedException {
        lock.lock();
        try {
            while (customers.size() == CAPACITY) {
                System.out.println("[PRODUCER] Waiting - db is full");
                dbNotEmpty.await();
            }
            final Random theRandom = new Random();
            Customer customer = new Customer("imie" + theRandom.nextInt(100), " nazwisko" + theRandom.nextInt(100));
            customers.offer(customer);
            System.out.println("[PRODUCER] Added to db: " + customer);
            System.out.println("[SIGNAL] DB is not empty from now");
            dbNotFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void insert() throws InterruptedException {
        lock.lock();
        try {
            while (customers.size() == 0) {
                System.out.println("[CONSUMER] Waiting - no data in db");
                        dbNotFull.await();
            }
            Customer customer = customers.poll();
            System.out.println("[CONSUMER] Consumed customer from db: " + customer);
            System.out.println("[SIGNAL] DB may be empty from now");
            dbNotEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
