package com.kodilla.zadanie1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class Processor {
    public Future<Integer> process(int x) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            Random random = new Random();
            System.out.println("Processor started processing");
            sleep(random.nextInt(10));
            System.out.println("Processor ended processing");
            return x * 1000;
        });
    }
}
