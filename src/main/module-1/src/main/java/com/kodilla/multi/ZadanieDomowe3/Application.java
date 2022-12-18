package com.kodilla.multi.ZadanieDomowe3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int n = 0; n < 400; n++) {
            executor.submit(new FileManager());
        }
        executor.shutdown();
    }
}
