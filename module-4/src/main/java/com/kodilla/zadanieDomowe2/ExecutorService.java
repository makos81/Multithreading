package com.kodilla.zadanieDomowe2;

public class ExecutorService {
    public static void main(String[] args) {
        final DataBase db = new DataBase();

        for (int i=0; i < 10; i++){
            new Consumer(db).start();
            new Producer(db).start();
        }
    }
}
