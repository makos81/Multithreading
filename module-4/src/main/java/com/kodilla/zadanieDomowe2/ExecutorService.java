package com.kodilla.zadanieDomowe2;

public class ExecutorService {
    public static void main(String[] args) {
        final DataBase db = new DataBase();
        final Consumer consumer1 = new Consumer(db);
        final Consumer consumer2 = new Consumer(db);
        final Producer producer1 = new Producer(db);
        final Producer producer2 = new Producer(db);
        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();
    }
}
