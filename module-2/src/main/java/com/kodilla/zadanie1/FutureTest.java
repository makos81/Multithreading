package com.kodilla.zadanie1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Processor processor = new Processor();
        final Future<Integer> futureResult1 = processor.process(5);
        final Future<Integer> futureResult2 = processor.process(10);

        while (!futureResult1.isDone() && !futureResult2.isDone()) {
            System.out.println("Status of task1 :" + futureResult1.isDone());
            System.out.println("Status of task2 :" + futureResult2.isDone());
            sleep(1);
        }

        final Integer result1 = futureResult1.get();
        final Integer result2 = futureResult2.get();
        System.out.println("Result of task1: " + result1);
        System.out.println("Result of task2: " + result2);
    }
}
