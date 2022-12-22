package com.kodilla.zadanieDomowe2;

import java.util.Random;

public class Producer extends Thread {
    private final DataBase db;
    public Producer(DataBase db) {
        this.db = db;
    }
    @Override
    public void run() {
        int counter = 0;
        final Random random = new Random();
        try {
            while (counter < 3) {
                db.insert();
                Thread.sleep(random.nextInt(1000));
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
