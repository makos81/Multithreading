package com.kodilla.multi.ZadanieDomowe3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class FileManager implements Runnable {
    private static Semaphore semaphore = new Semaphore(10);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            readFile();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void readFile() throws InterruptedException {
        Random random = new Random();
        synchronized (FileManager.class) {
            System.out.println("Reading file ");
        }
        Thread.sleep(random.nextInt(100));
        synchronized (FileManager.class) {
        }
    }
}
